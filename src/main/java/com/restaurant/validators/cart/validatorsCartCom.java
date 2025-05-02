package com.restaurant.validators.cart;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurant.exceptions.cart.SearchCartException;
import com.restaurant.exceptions.cart.UpdatedRecipeServingsExceptions;
import com.restaurant.model.document.Menu;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.document.ShoppingCart;
import com.restaurant.repository.ShoppingCartRespository;
import com.restaurant.service.implementation.inventory.RecipeServices;
import com.restaurant.validators.Interface.cart.CartValidatorsInt;

@Component
public class validatorsCartCom implements CartValidatorsInt {

  @Autowired
  ShoppingCartRespository shoppingCartRespository;

  @Autowired
  RecipeServices recipeServices;

  @Override
  public UUID createIdCart() {
    return UUID.randomUUID();
  }

  @Override
  public ShoppingCart searchCart(String id) {
    Optional<ShoppingCart> cart = shoppingCartRespository.findById(id);
    if (cart.isEmpty()) {
      throw new SearchCartException("not found cart");
    }
    return cart.get();
  }

  @Override
  public int validatorAmountRecipe(String id, int amount) {
    Recipe recipe = recipeServices.getRecipeById(id);
    if (recipe.getServings() >= amount) {
      return 1;
    } else {
      return 0;
    }
  }

  @Override
  public void updatedRecipeAmount(String id, int amount) {
    if (validatorAmountRecipe(id, amount) == 1) {
      recipeServices.uptadesServingsRecipe(id, amount);
    } else {
      throw new UpdatedRecipeServingsExceptions();
    }
  }

  @Override
  public void runListMenus(ArrayList<Menu> menus) {
    for (Menu menu : menus) {
      menu.getMenuItems().values().stream()
          .map(Recipe::getId)
          .forEach(id -> {
            if (validatorAmountRecipe(id, menu.getAmount()) == 1) {
              updatedRecipeAmount(id, menu.getAmount());
            } else {
              throw new UpdatedRecipeServingsExceptions("amount no accepted");
            }
          });
    }

  }

  @Override
  public int deleteItems(int rest) {
    if (rest == 0) {
      return 0;
    } else {
      return 1;
    }
  }

  @Override
  public ArrayList<Menu> deleteItems(ArrayList<Menu> menus, String idShopping) {
    ArrayList<Menu> men = new ArrayList<>();
    for (Menu menu : menus) {
      if (menu.getRest() >= 1 && menu.getAmount() > 0) {
        menu.getMenuItems().values().stream()
            .map(Recipe::getId)
            .forEach(id -> {
              recipeServices.uptadedRecipeCount(id, menu.getRest());
            });
      } else {
        men.add(menu);
      }
    }
    return men;
  }

}
