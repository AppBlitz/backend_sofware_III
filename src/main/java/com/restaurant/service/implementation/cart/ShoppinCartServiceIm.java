package com.restaurant.service.implementation.cart;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dto.cart.UpdateShopping;
import com.restaurant.exceptions.cart.SearchCartException;
import com.restaurant.model.Enum.cart.StateCart;
import com.restaurant.model.document.ShoppingCart;
import com.restaurant.repository.ShoppingCartRespository;
import com.restaurant.service.Interface.cart.ShoppingCartServiceInterface;
import com.restaurant.validators.cart.ValidatorsCart;

@Service
public class ShoppinCartServiceIm implements ShoppingCartServiceInterface {

  @Autowired
  ShoppingCartRespository shoppingCartRespository;

  @Autowired
  ValidatorsCart validatorsCart;

  @Override
  public ShoppingCart createShoppingCart() {
    ShoppingCart cart = ShoppingCart.builder()
        .dateCreation(LocalDate.now())
        .stateCart(StateCart.PENDING)
        .build();
    return shoppingCartRespository.save(cart);
  }

  @Override
  public ShoppingCart searchShoppingCartId(String id) {
    return shoppingCartRespository.findById(id).orElseThrow(() -> new SearchCartException("The cart not found"));
  }

  @Override
  public ShoppingCart addProducAnShopping(UpdateShopping UpdateShopping) {
    ShoppingCart cart = searchShoppingCartId(UpdateShopping.id());
    ShoppingCart updateCart = cart;
    validatorsCart.modificationData(UpdateShopping.items());
    updateCart.setItems(UpdateShopping.items());
    return shoppingCartRespository.save(updateCart);
  }

}
