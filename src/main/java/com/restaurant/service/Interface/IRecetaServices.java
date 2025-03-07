package com.restaurant.service.Interface;

import com.restaurant.model.document.Receta;
import java.util.List;

/**
 * Interfaz para el servicio de gestión de recetas.
 * Proporciona métodos para realizar operaciones CRUD en recetas.
 */
public interface IRecetaServices {

    /**
     * Crea una nueva receta.
     *
     * @param receta La receta a crear.
     * @return La receta creada.
     */
    Receta crearReceta(Receta receta);

    /**
     * Obtiene una receta por su ID.
     *
     * @param id El ID de la receta a obtener.
     * @return La receta correspondiente al ID, o null si no se encuentra.
     */
    Receta obtenerRecetaPorId(Integer id);

    /**
     * Obtiene todas las recetas.
     *
     * @return Una lista de todas las recetas.
     */
    List<Receta> obtenerTodasLasRecetas();

    /**
     * Actualiza una receta existente.
     *
     * @param id El ID de la receta a actualizar.
     * @param receta La receta actualizada.
     * @return La receta actualizada, o null si no se encuentra la receta con el ID proporcionado.
     */
    Receta actualizarReceta(Integer id, Receta receta);

    /**
     * Elimina una receta por su ID.
     *
     * @param id El ID de la receta a eliminar.
     */
    void eliminarReceta(Integer id);
}