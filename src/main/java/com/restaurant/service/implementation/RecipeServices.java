package com.restaurant.service.implementation;

import com.restaurant.model.document.Recipe;
import com.restaurant.repository.RecetaRepository;
import com.restaurant.service.Interface.IRecipeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de gestión de recetas.
 * Proporciona métodos para realizar operaciones CRUD en recetas.
 */
@Service
public class RecipeServices implements IRecipeServices {

    @Autowired
    private RecetaRepository recetaRepository;

    /**
     * Crea una nueva recipe.
     *
     * @param recipe La recipe a crear.
     * @return La recipe creada.
     */
    @Override
    public Recipe crearReceta(Recipe recipe) {
        return recetaRepository.save(recipe);
    }

    /**
     * Obtiene una receta por su ID.
     *
     * @param id El ID de la receta a obtener.
     * @return La receta correspondiente al ID, o null si no se encuentra.
     */
    @Override
    public Recipe obtenerRecetaPorId(Integer id) {
        Optional<Recipe> receta = recetaRepository.findById(id);
        return receta.orElse(null);
    }

    /**
     * Obtiene todas las recetas.
     *
     * @return Una lista de todas las recetas.
     */
    @Override
    public List<Recipe> obtenerTodasLasRecetas() {
        return recetaRepository.findAll();
    }

    /**
     * Actualiza una recipe existente.
     *
     * @param id El ID de la recipe a actualizar.
     * @param recipe La recipe actualizada.
     * @return La recipe actualizada, o null si no se encuentra la recipe con el ID proporcionado.
     */
    @Override
    public Recipe actualizarReceta(Integer id, Recipe recipe) {
        if (recetaRepository.existsById(id)) {
            recipe.setId(id);
            return recetaRepository.save(recipe);
        }
        return null;
    }

    /**
     * Elimina una receta por su ID.
     *
     * @param id El ID de la receta a eliminar.
     */
    @Override
    public void eliminarReceta(Integer id) {
        recetaRepository.deleteById(id);
    }
}