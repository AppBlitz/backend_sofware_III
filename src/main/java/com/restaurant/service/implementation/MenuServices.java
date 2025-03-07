package com.restaurant.service.implementation;

import com.restaurant.model.document.Menu;
import com.restaurant.repository.MenuRepository;
import com.restaurant.service.Interface.IMenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de gestión de menús.
 * Proporciona métodos para realizar operaciones CRUD en menús.
 */
@Service
public class MenuServices implements IMenuServices {

    @Autowired
    private MenuRepository menuRepository;

    /**
     * Crea un nuevo menú.
     *
     * @param menu El menú a crear.
     * @return El menú creado.
     */
    @Override
    public Menu crearMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    /**
     * Obtiene un menú por su ID.
     *
     * @param id El ID del menú a obtener.
     * @return El menú correspondiente al ID, o null si no se encuentra.
     */
    @Override
    public Menu obtenerMenuPorId(Integer id) {
        Optional<Menu> menu = menuRepository.findById(id);
        return menu.orElse(null);
    }

    /**
     * Obtiene todos los menús.
     *
     * @return Una lista de todos los menús.
     */
    @Override
    public List<Menu> obtenerTodosLosMenus() {
        return menuRepository.findAll();
    }

    /**
     * Actualiza un menú existente.
     *
     * @param id El ID del menú a actualizar.
     * @param menu El menú actualizado.
     * @return El menú actualizado, o null si no se encuentra el menú con el ID proporcionado.
     */
    @Override
    public Menu actualizarMenu(Integer id, Menu menu) {
        if (menuRepository.existsById(id)) {
            menu.setId(id);
            return menuRepository.save(menu);
        }
        return null;
    }

    /**
     * Elimina un menú por su ID.
     *
     * @param id El ID del menú a eliminar.
     */
    @Override
    public void eliminarMenu(Integer id) {
        menuRepository.deleteById(id);
    }
}