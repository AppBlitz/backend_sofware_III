package com.restaurant.controller.Interface.recipe;

import com.restaurant.dto.recipe.MenuDtoAdd;
import com.restaurant.dto.recipe.MenuDtoUpdate;
import com.restaurant.model.document.Menu;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MenuControllerInterface {

    ResponseEntity<Menu> createMenu(MenuDtoAdd menuDtoAdd);

    ResponseEntity<Menu> getMenuById(Integer id);

    ResponseEntity<List<Menu>> getAllMenus();

    ResponseEntity<Menu> updateMenu(Integer id, MenuDtoUpdate menuDtoUpdate);

    ResponseEntity<Void> deleteMenu(Integer id);
}