package com.restaurant.controller.implementation.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.model.document.*;
import com.restaurant.model.vo.Items;
import com.restaurant.controller.Interface.cart.ShoppingCartInter;
import com.restaurant.dto.cart.SearchDateCreation;
import com.restaurant.dto.cart.SearchShoppingCartCategory;
import com.restaurant.service.implementation.cart.ShoppinCartServiceIm;

@RestController
@RequestMapping("/cart")
public class ControllerCart implements ShoppingCartInter {

  @Autowired
  ShoppinCartServiceIm shoppinService;

  @Override
  @RequestMapping(value = "/create", method = RequestMethod.POST)
  public ResponseEntity<ShoppingCart> createShoppingCart() {
    return ResponseEntity.ok(shoppinService.createShoppingCart());
  }

  @Override
  @RequestMapping(value = "/search/{idShopping}", method = RequestMethod.GET)
  public ResponseEntity<ShoppingCart> searchId(@PathVariable("idShopping") String idShopping) {
    return ResponseEntity.ok(shoppinService.searchShoppingCartId(idShopping));
  }

  @Override
  @RequestMapping(value = "/delete/{idShopping}", method = RequestMethod.DELETE)
  public ResponseEntity<String> deleteShoppingCart(@PathVariable("idShopping") String idShopping) {
    shoppinService.deleteShopping(idShopping);
    return ResponseEntity.ok("deleted car succesfully");
  }

  @Override
  @RequestMapping(value = "/item/category", method = RequestMethod.POST)
  public ResponseEntity<List<Items>> searchCategory(SearchShoppingCartCategory category) {
    return ResponseEntity.ok(null);
  }

  @Override
  @RequestMapping(value = "/search/recipe/{idShoppingCart}")
  public ResponseEntity<List<Recipe>> searchRecipeShoppingCart(@PathVariable("idShoppingCart") String idShoppingCart) {
    return ResponseEntity.ok(shoppinService.getAllRecipe(idShoppingCart));
  }

  @Override
  @RequestMapping(value = "/search/product/{id}", method = RequestMethod.GET)
  public ResponseEntity<List<Product>> searchProductShopping(@PathVariable("id") String id) {
    return ResponseEntity.ok(shoppinService.getAllProduct(id));
  }

  @Override
  @RequestMapping(value = "/search/date", method = RequestMethod.POST)
  public ResponseEntity<List<ShoppingCart>> searchDateCreation(@RequestBody SearchDateCreation dateCreation) {
    return ResponseEntity.ok(shoppinService.getDateCreation(dateCreation.dateCreation()));
  }

}
