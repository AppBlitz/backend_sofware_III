package com.restaurant.controller.Interface.cart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurant.dto.cart.ActivateShopping;
import com.restaurant.dto.cart.AddProductDto;
import com.restaurant.model.document.ShoppingCart;

public interface ShoppingCartInter {
  public ResponseEntity<ShoppingCart> createCart();

  public ResponseEntity<ShoppingCart> addProduct(@RequestBody AddProductDto addProductDto);

  public ResponseEntity<String> deleteShopping(String id);

  public ResponseEntity<ShoppingCart> activateShopping(ActivateShopping activateShopping);

}
