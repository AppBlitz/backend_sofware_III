package com.restaurant.service.Interface;

import com.restaurant.model.document.Menu;
import java.util.List;

/**
 * Interfaz para el servicio de gestión de menús.
 * Proporciona métodos para realizar operaciones CRUD en menús.
 */
public interface IMenuServices {

    /**
     * Crea un nuevo menú.
     *
     * @param menu El menú a crear.
     * @return El menú creado.
     */
    Menu crearMenu(Menu menu);

    /**
     * Obtiene un menú por su ID.
     *
     * @param id El ID del menú a obtener.
     * @return El menú correspondiente al ID, o null si no se encuentra.
     */
    Menu obtenerMenuPorId(Integer id);

    /**
     * Obtiene todos los menús.
     *
     * @return Una lista de todos los menús.
     */
    List<Menu> obtenerTodosLosMenus();

    /**
     * Actualiza un menú existente.
     *
     * @param id El ID del menú a actualizar.
     * @param menu El menú actualizado.
     * @return El menú actualizado, o null si no se encuentra el menú con el ID proporcionado.
     */
    Menu actualizarMenu(Integer id, Menu menu);

    /**
     * Elimina un menú por su ID.
     *
     * @param id El ID del menú a eliminar.
     */
    void eliminarMenu(Integer id);
}