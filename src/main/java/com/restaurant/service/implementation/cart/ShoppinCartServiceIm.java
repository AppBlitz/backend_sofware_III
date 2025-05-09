package com.restaurant.service.implementation.cart;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dto.cart.SearchCartCategory;
import com.restaurant.dto.cart.UpdateShopping;
import com.restaurant.exceptions.cart.SearchCartException;
import com.restaurant.model.Enum.cart.StateCart;
import com.restaurant.model.document.Product;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.document.ShoppingCart;
import com.restaurant.repository.ShoppingCartRespository;
import com.restaurant.service.Interface.cart.ShoppingCartServiceInterface;
import com.restaurant.service.implementation.inventory.ProductService;
import com.restaurant.service.implementation.inventory.RecipeServices;
import com.restaurant.validators.cart.ValidatorsCart;

import lombok.*;

@Service
public class ShoppinCartServiceIm implements ShoppingCartServiceInterface {

  @Autowired
  ShoppingCartRespository shoppingCartRespository;

  @Autowired
  ValidatorsCart validatorsCart;

  @Autowired
  private RecipeServices rServices;

  @Autowired
  private ProductService pServices;

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

  @Override
  public void deleteShopping(@NonNull String idShopping) {
    ShoppingCart cartUpdate = searchShoppingCartId(idShopping);
    cartUpdate.setStateCart(StateCart.INACTIVE);
    shoppingCartRespository.save(cartUpdate);
  }

  public List<Recipe> getAllRecipe(@NonNull String idShoppingCart) {
    ShoppingCart cart = searchShoppingCartId(idShoppingCart);
    List<Recipe> recipes = rServices.listAllRecipe(cart.getItems());
    return recipes;

  }

  @Override
  public List<Product> getAllProduct(@NonNull String id) {
    return pServices.getAllProductShoppingCart(searchShoppingCartId(id).getItems());
  }

  @Override
  public List<ShoppingCart> getDateCreation(@NonNull LocalDate dateCreation) {
    return shoppingCartRespository.findByDateCreation(dateCreation);
  }

  @Override
  public List<ShoppingCart> searchCategory(SearchCartCategory category) {
    return shoppingCartRespository.findByStateCart(category.stateCart());
  }
}
