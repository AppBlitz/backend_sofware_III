package com.restaurant.controller.implementation.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.model.document.*;

import com.restaurant.controller.Interface.cart.ShoppingCartInter;
import com.restaurant.service.implementation.cart.ShoppinCartServiceIm;

@RestController
@RequestMapping("cart")
public class ControllerCart implements ShoppingCartInter {

  @Autowired
  ShoppinCartServiceIm shoppinService;

  @Override
  public ResponseEntity<ShoppingCart> createShoppingCart() {
    return ResponseEntity.ok(shoppinService.createShoppingCart());
  }

}
