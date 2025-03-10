package com.restaurant.controller.implementation.recipe;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.controller.Interface.recipe.MenuControllerInterface;
import com.restaurant.dto.recipe.MenuDtoAdd;
import com.restaurant.dto.recipe.MenuDtoUpdate;
import com.restaurant.model.document.Menu;
import com.restaurant.service.implementation.MenuServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/menus")
@CrossOrigin(origins = "*")
public class MenuController implements MenuControllerInterface {

    @Autowired
    private MenuServices menuServices;

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Menu> createMenu(@Valid @RequestBody MenuDtoAdd menuDtoAdd) {
        Menu menu = new Menu();
        menu.setMenuItems(new HashMap<>(menuDtoAdd.menuItems()));
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
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Menu>> getAllMenus() {
        List<Menu> menus = menuServices.getAllMenus();
        return ResponseEntity.ok(menus);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Menu> updateMenu(@PathVariable Integer id, @Valid @RequestBody MenuDtoUpdate menuDtoUpdate) {
        Menu menu = new Menu();
        menu.setId(menuDtoUpdate.id());
        menu.setMenuItems(new HashMap<>(menuDtoUpdate.menuItems()));
        menu.setDate(menuDtoUpdate.date());
        Menu updatedMenu = menuServices.updateMenu(id, menu);
        if (updatedMenu != null) {
            return ResponseEntity.ok(updatedMenu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteMenu(@PathVariable Integer id) {
        menuServices.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }
}
