package com.restaurant.service.implementation;

import com.restaurant.model.document.Receta;
import com.restaurant.repository.RecetaRepository;
import com.restaurant.service.Interface.IRecetaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de gestión de recetas.
 * Proporciona métodos para realizar operaciones CRUD en recetas.
 */
@Service
public class RecetaServices implements IRecetaServices {

    @Autowired
    private RecetaRepository recetaRepository;

    /**
     * Crea una nueva receta.
     *
     * @param receta La receta a crear.
     * @return La receta creada.
     */
    @Override
    public Receta crearReceta(Receta receta) {
        return recetaRepository.save(receta);
    }

    /**
     * Obtiene una receta por su ID.
     *
     * @param id El ID de la receta a obtener.
     * @return La receta correspondiente al ID, o null si no se encuentra.
     */
    @Override
    public Receta obtenerRecetaPorId(Integer id) {
        Optional<Receta> receta = recetaRepository.findById(id);
        return receta.orElse(null);
    }

    /**
     * Obtiene todas las recetas.
     *
     * @return Una lista de todas las recetas.
     */
    @Override
    public List<Receta> obtenerTodasLasRecetas() {
        return recetaRepository.findAll();
    }

    /**
     * Actualiza una receta existente.
     *
     * @param id El ID de la receta a actualizar.
     * @param receta La receta actualizada.
     * @return La receta actualizada, o null si no se encuentra la receta con el ID proporcionado.
     */
    @Override
    public Receta actualizarReceta(Integer id, Receta receta) {
        if (recetaRepository.existsById(id)) {
            receta.setId(id);
            return recetaRepository.save(receta);
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