package com.restaurant.service.Interface.inventory;

import com.restaurant.model.document.Menu;
import java.util.List;

/**
 * Interface for the menu management service.
 * Provides methods for performing CRUD operations on menus.
 */
public interface IMenuServices {

    /**
     * Creates a new menu.
     *
     * @param menu The menu to create.
     * @return The created menu.
     */
    Menu createMenu(Menu menu);

    /**
     * Gets a menu by its ID.
     *
     * @param id The ID of the menu to retrieve.
     * @return The menu corresponding to the ID, or null if not found.
     */
    Menu getMenuById(Integer id);

    /**
     * Gets all menus.
     *
     * @return A list of all menus.
     */
    List<Menu> getAllMenus();

    /**
     * Updates an existing menu.
     *
     * @param id   The ID of the menu to update.
     * @param menu The updated menu.
     * @return The updated menu, or null if the menu with the provided ID is not found.
     */
    Menu updateMenu(Integer id, Menu menu);

    /**
     * Deletes a menu by its ID.
     *
     * @param id The ID of the menu to delete.
     */
    void deleteMenu(Integer id);
}
