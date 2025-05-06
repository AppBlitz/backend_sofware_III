package com.restaurant.controller.Interface.recipe;

import com.restaurant.dto.recipe.MenuALl;
import com.restaurant.dto.recipe.MenuDateDto;
import com.restaurant.dto.recipe.MenuDtoAdd;
import com.restaurant.dto.recipe.MenuDtoUpdate;
import com.restaurant.model.document.Menu;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MenuControllerInterface {

    ResponseEntity<Menu> createMenu(MenuDtoAdd menuDtoAdd);

    ResponseEntity<Menu> getMenuById(Integer id);

    ResponseEntity<List<MenuALl>> getAllMenusNameAndDate();

    ResponseEntity<Menu> updateMenu(Integer id, MenuDtoUpdate menuDtoUpdate);

    ResponseEntity<Void> deleteMenu(Integer id);

    ResponseEntity<List<Menu>> listMenusDates(MenuDateDto menuDateDto) throws Exception;

    ResponseEntity<List<Menu>> getAll() throws Exception;

}
