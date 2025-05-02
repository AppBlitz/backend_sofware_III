package com.restaurant.validators.Interface.cart;

import java.util.ArrayList;
import java.util.UUID;

import com.restaurant.model.document.Menu;
import com.restaurant.model.document.ShoppingCart;

public interface CartValidatorsInt {

  public UUID createIdCart();

  public ShoppingCart searchCart(String id);

  public int validatorAmountRecipe(String id, int amount);

  public void updatedRecipeAmount(String id, int amount);

  public void runListMenus(ArrayList<Menu> menus);

  public int deleteItems(int rest);

}
