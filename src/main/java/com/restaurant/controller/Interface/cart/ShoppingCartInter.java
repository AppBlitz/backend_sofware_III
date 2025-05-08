package com.restaurant.controller.Interface.cart;

import org.springframework.http.ResponseEntity;
import com.restaurant.model.document.ShoppingCart;

public interface ShoppingCartInter {

  public ResponseEntity<ShoppingCart> createShoppingCart();
}
