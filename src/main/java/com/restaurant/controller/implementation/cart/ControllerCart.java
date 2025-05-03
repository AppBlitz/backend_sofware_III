package com.restaurant.controller.implementation.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
  public ResponseEntity<String> deleteShopping(@PathVariable("id") String id) {
    shoppinService.deleteCar(id);
    return ResponseEntity.ok("cart deleted succesfully");
  }

  @Override
  @RequestMapping(value = "/activate", method = RequestMethod.POST)
  public ResponseEntity<ShoppingCart> activateShopping(@RequestBody ActivateShopping activateShopping) {
    return ResponseEntity.ok(shoppinService.activateCart(activateShopping));
  }

  @Override
  @RequestMapping(value = "/get/all", method = RequestMethod.GET)
  public ResponseEntity<List<ShoppingCart>> getAllShopping() {
    return ResponseEntity.ok(shoppinService.getAllShopping());
  }

  @Override
  public ResponseEntity<ShoppingCart> searchShoppingId(@PathVariable("id") String id) {
    return ResponseEntity.status(200).body(shoppinService.searchCartId(id));
  }

}
