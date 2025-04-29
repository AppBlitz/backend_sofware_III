package com.restaurant.service.implementation.cart;

import org.springframework.beans.factory.annotation.Autowired;

import com.restaurant.model.document.ShoppingCart;
import com.restaurant.repository.ShoppingCartRespository;
import com.restaurant.service.Interface.cart.ShoppingCartServiceInterface;
import com.restaurant.validators.cart.validatorsCartCom;

public class ShoppinCartServiceIm implements ShoppingCartServiceInterface {

  @Autowired
  ShoppingCartRespository shoppingCartRepository;

  @Autowired
  validatorsCartCom validatorsCartCom;

  @Override
  public ShoppingCart addMenuCart() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addMenuCart'");
  }

  @Override
  public ShoppingCart createShoppingCart() {
    ShoppingCart cart = ShoppingCart.builder()
        .build();
    return shoppingCartRepository.save(cart);
  }

}
