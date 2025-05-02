package com.restaurant.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.dto.cart.ActivateShopping;
import com.restaurant.dto.cart.AddProductDto;
import com.restaurant.dto.cart.DeleteMenuShopping;
import com.restaurant.model.Enum.cart.StateCart;
import com.restaurant.model.document.Menu;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.document.ShoppingCart;
import com.restaurant.service.implementation.cart.ShoppinCartServiceIm;
import com.restaurant.service.implementation.inventory.RecipeServices;

@SpringBootTest
public class ShoppinCartServiceTest {

  @Autowired
  ShoppinCartServiceIm shoppinCartServiceIm;

  @Autowired
  RecipeServices recipeServices;

  @Test
  public void createCart() {
    assertEquals(shoppinCartServiceIm.createShoppingCart().getAmount(), 0);
  }

  @Test
  public void deleteCart() {
    String id = "b4d95f9e-f08c-4bbb-ae9e-136e45784a9f";
    ShoppingCart actual = shoppinCartServiceIm.searchCartId(id);
    shoppinCartServiceIm.deleteCar(id);
    assertNotEquals(shoppinCartServiceIm.searchCartId(id), actual, "Cart deleted succesfully");
  }

  @Test
  public void activateShooping() {
    ActivateShopping activate = new ActivateShopping("b4d95f9e-f08c-4bbb-ae9e-136e45784a9f");
    ShoppingCart actual = shoppinCartServiceIm.searchCartId(activate.id());
    shoppinCartServiceIm.activateCart(activate);
    assertNotEquals(shoppinCartServiceIm.searchCartId(activate.id()).getStateCart(), actual.getStateCart(),
        "The shopping activate with success");
  }

  @Test
  public void addProductShopping() {
    HashMap<String, Recipe> menu = new HashMap<>();
    Recipe recipe = recipeServices.getRecipeById("680290f571ae414c518bf1ca");
    menu.put(recipe.id, recipe);
    LocalTime time = LocalTime.now();
    Menu menus = Menu.builder()
        .menuItems(menu)
        .date(time)
        .amount(3)
        .rest(1)
        .build();

    ArrayList<Menu> listMenu = new ArrayList<>();
    listMenu.add(menus);

    DeleteMenuShopping product = new DeleteMenuShopping("b4d95f9e-f08c-4bbb-ae9e-136e45784a9f", StateCart.PENDING,
        listMenu,
        3);

    assertNotNull(shoppinCartServiceIm.deleteMenu(product));
  }

}
