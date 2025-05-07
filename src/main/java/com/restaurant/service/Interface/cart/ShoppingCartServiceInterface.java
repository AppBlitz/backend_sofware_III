package com.restaurant.service.Interface.cart;

import com.restaurant.dto.cart.UpdateShopping;
import com.restaurant.model.document.ShoppingCart;

public interface ShoppingCartServiceInterface {

  public ShoppingCart createShoppingCart();

  public ShoppingCart searchShoppingCartId(String id);

  public ShoppingCart addProducAnShopping(UpdateShopping UpdateShopping);
}
