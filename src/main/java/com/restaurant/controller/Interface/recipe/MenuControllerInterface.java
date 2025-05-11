package com.restaurant.controller.Interface.recipe;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.restaurant.dto.menu.CreateMenuDto;
import com.restaurant.dto.recipe.MenuALl;
import com.restaurant.dto.recipe.MenuDateDto;
import com.restaurant.model.document.Menu;

public interface MenuControllerInterface {

    ResponseEntity<Menu> createMenu(CreateMenuDto menuDto);

    ResponseEntity<Menu> getMenuById(String id);

    ResponseEntity<List<MenuALl>> getAllMenusNameAndDate();

    ResponseEntity<Void> deleteMenu(String id);

    ResponseEntity<List<Menu>> listMenusDates(MenuDateDto menuDateDto) throws Exception;

    ResponseEntity<List<Menu>> getAll() throws Exception;

}
