package com.restaurant.controller.implementation.recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.controller.Interface.recipe.MenuControllerInterface;
import com.restaurant.dto.recipe.MenuALl;
import com.restaurant.dto.recipe.MenuDateDto;
import com.restaurant.dto.recipe.MenuDtoAdd;
import com.restaurant.model.document.Menu;
import com.restaurant.service.implementation.inventory.MenuServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/menus")
public class MenuController implements MenuControllerInterface {

    @Autowired
    private MenuServices menuServices;

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Menu> createMenu(@Valid @RequestBody MenuDtoAdd menuDtoAdd) {
        Menu menu = new Menu();
        menu.setDate(menuDtoAdd.date());
        Menu newMenu = menuServices.createMenu(menu);
        return ResponseEntity.status(200).body(newMenu);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Menu> getMenuById(@PathVariable Integer id) {
        Menu menu = menuServices.getMenuById(id);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @RequestMapping(value = "name/date", method = RequestMethod.GET)
    public ResponseEntity<List<MenuALl>> getAllMenusNameAndDate() {
        List<MenuALl> menus = menuServices.getAllMenusNameAndDate();
        return ResponseEntity.ok(menus);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMenu(@PathVariable Integer id) {
        menuServices.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @RequestMapping(value = "/date", method = RequestMethod.POST)
    public ResponseEntity<List<Menu>> listMenusDates(@RequestBody MenuDateDto menuDateDto) throws Exception {
        return ResponseEntity.ok(menuServices.getAllMenuForDate(menuDateDto));
    }

    @Override
    public ResponseEntity<List<Menu>> getAll() throws Exception {
        return ResponseEntity.ok(menuServices.getAll());
    }
}
