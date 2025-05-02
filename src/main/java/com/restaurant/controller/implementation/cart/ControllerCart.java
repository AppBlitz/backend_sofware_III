package com.restaurant.controller.implementation.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.controller.Interface.cart.ShoppingCartInter;
import com.restaurant.dto.cart.ActivateShopping;
import com.restaurant.dto.cart.AddProductDto;
import com.restaurant.model.document.ShoppingCart;
import com.restaurant.service.implementation.cart.ShoppinCartServiceIm;

@RestController
@RequestMapping("cart")
public class ControllerCart implements ShoppingCartInter {

  @Autowired
  ShoppinCartServiceIm shoppinService;

  @Override
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<ShoppingCart> createCart() {
    return ResponseEntity.ok(shoppinService.createShoppingCart());
  }

  @Override
  @RequestMapping(value = "/add/menu", method = RequestMethod.POST)
  public ResponseEntity<ShoppingCart> addProduct(@RequestBody AddProductDto addProductDto) {
    return ResponseEntity.ok(shoppinService.addMenuCart(addProductDto));
  }

  @Override
  @RequestMapping(value = "/delete/shopping", method = RequestMethod.DELETE)
  public ResponseEntity<String> deleteShopping(String id) {
    shoppinService.deleteCar(id);
    return ResponseEntity.ok("cart deleted succesfully");
  }

  @Override
  @RequestMapping(value = "/activate", method = RequestMethod.POST)
  public ResponseEntity<ShoppingCart> activateShopping(@RequestBody ActivateShopping activateShopping) {
    return ResponseEntity.ok(shoppinService.activateCart(activateShopping));
  }

}
