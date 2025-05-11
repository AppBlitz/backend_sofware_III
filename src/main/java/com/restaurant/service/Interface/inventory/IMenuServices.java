package com.restaurant.service.Interface.inventory;

import com.restaurant.dto.menu.CreateMenuDto;
import com.restaurant.dto.recipe.MenuALl;
import com.restaurant.dto.recipe.MenuDateDto;
import com.restaurant.exceptions.menu.normal.MenuExceptionGetAll;
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
    Menu createMenu(CreateMenuDto menuDto);

    /**
     * Gets a menu by its ID.
     *
     * @param id The ID of the menu to retrieve.
     * @return The menu corresponding to the ID, or null if not found.
     */
    Menu getMenuById(String id);

    /**
     * Gets all menus.
     *
     * @return A list of all menus.
     */
    List<MenuALl> getAllMenusNameAndDate();

    /**
     * Updates an existing menu.
     *
     * @param id   The ID of the menu to update.
     * @param menu The updated menu.
     * @return The updated menu, or null if the menu with the provided ID is not
     *         found.
     */

    /**
     * Deletes a menu by its ID.
     *
     * @param id The ID of the menu to delete.
     */
    void deleteMenu(String id);

    public List<Menu> getAllMenuForDate(MenuDateDto menuDateDto);

    public List<Menu> getAll() throws MenuExceptionGetAll;

}
