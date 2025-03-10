package com.restaurant.service.implementation;

import com.restaurant.model.document.Menu;
import com.restaurant.repository.MenuRepository;
import com.restaurant.service.Interface.IMenuServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the menu management service.
 * Provides methods for performing CRUD operations on menus.
 */
@Service
public class MenuServices implements IMenuServices {

    @Autowired
    private MenuRepository menuRepository;

    /**
     * Creates a new menu.
     *
     * @param menu The menu to create.
     * @return The created menu.
     */
    @Override
    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    /**
     * Gets a menu by its ID.
     *
     * @param id The ID of the menu to retrieve.
     * @return The menu corresponding to the ID, or null if not found.
     */
    @Override
    public Menu getMenuById(Integer id) {
        Optional<Menu> menu = menuRepository.findById(id);
        return menu.orElse(null);
    }

    /**
     * Gets all menus.
     *
     * @return A list of all menus.
     */
    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    /**
     * Updates an existing menu.
     *
     * @param id The ID of the menu to update.
     * @param menu The updated menu.
     * @return The updated menu, or null if the menu with the provided ID is not found.
     */
    @Override
    public Menu updateMenu(Integer id, Menu menu) {
        if (menuRepository.existsById(id)) {
            menu.setId(id);
            return menuRepository.save(menu);
        }
        return null;
    }

    /**
     * Deletes a menu by its ID.
     *
     * @param id The ID of the menu to delete.
     */
    @Override
    public void deleteMenu(Integer id) {
        menuRepository.deleteById(id);
    }
}