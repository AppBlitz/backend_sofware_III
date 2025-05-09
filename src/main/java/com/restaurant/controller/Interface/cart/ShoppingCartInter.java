package com.restaurant.controller.Interface.cart;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurant.dto.cart.SearchCartCategory;
import com.restaurant.dto.cart.SearchDateCreation;
import com.restaurant.dto.cart.SearchShoppingCartCategory;
import com.restaurant.model.document.Product;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.document.ShoppingCart;
import com.restaurant.model.vo.Items;

public interface ShoppingCartInter {

  public ResponseEntity<ShoppingCart> createShoppingCart();

  public ResponseEntity<ShoppingCart> searchId(@PathVariable String idShopping);

  public ResponseEntity<String> deleteShoppingCart(@PathVariable String idShopping);

  public ResponseEntity<List<Items>> searchCategory(SearchShoppingCartCategory category);

  public ResponseEntity<List<Recipe>> searchRecipeShoppingCart(@PathVariable String idShoppingcart);

  public ResponseEntity<List<Product>> searchProductShopping(@PathVariable String id);

  public ResponseEntity<List<ShoppingCart>> searchDateCreation(@RequestBody SearchDateCreation dateCreation);

  public ResponseEntity<List<ShoppingCart>> searchStateCart(@RequestBody SearchCartCategory category);
}
