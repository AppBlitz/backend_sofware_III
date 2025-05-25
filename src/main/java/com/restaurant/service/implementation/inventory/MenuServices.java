package com.restaurant.service.implementation.inventory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dto.menu.CreateMenuDto;
import com.restaurant.dto.recipe.MenuALl;
import com.restaurant.dto.recipe.MenuDateDto;
import com.restaurant.exceptions.menu.normal.MenuExceptionGetAll;
import com.restaurant.exceptions.menu.runtime.MenuExceptionSearch;
import com.restaurant.model.document.Menu;
import com.restaurant.repository.MenuRepository;
import com.restaurant.service.Interface.inventory.IMenuServices;

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

    /**
     * Gets a menu by its ID.
     *
     * @param id The ID of the menu to retrieve.
     * @return The menu corresponding to the ID, or null if not found.
     */
    @Override
    public Menu getMenuById(String id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if (menu.isEmpty())
            throw new MenuExceptionSearch("menu not found");
        return menu.get();
    }

    /**
     * Gets all menus.
     *
     * @return A list of all menus.
     */
    @Override
    public List<MenuALl> getAllMenusNameAndDate() {
        List<MenuALl> allMenus = new ArrayList<>();
        List<Menu> menus = menuRepository.findAll();
        for (Menu menu : menus) {
            MenuALl menuAll = new MenuALl(menu.getId() + "", menu.getName(), menu.getDate());
            allMenus.add(menuAll);
        }
        return allMenus;
    }

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
    @Override
    public void deleteMenu(String id) {
        menuRepository.deleteByid(id);
    }

    @Override
    public List<Menu> getAllMenuForDate(MenuDateDto menuDateDtoh) {
        List<Menu> menus = menuRepository.findByDates(menuDateDtoh.date());
        return menus;
    }

    @Override
    public List<Menu> getAll() throws MenuExceptionGetAll {
        return menuRepository.findAll();
    }

    @Override
    public Menu createMenu(CreateMenuDto menuDto) {
        Menu menu = Menu.builder()
                .name(menuDto.name())
                .idemployeeKitchen(menuDto.idkitchenEmployee())
                .items(menuDto.items())
                .date(LocalDate.now())
                .description(menuDto.description())
                .build();
        return menuRepository.save(menu);
    }

}
