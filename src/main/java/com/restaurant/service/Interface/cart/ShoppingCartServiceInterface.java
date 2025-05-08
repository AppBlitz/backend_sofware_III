package com.restaurant.service.Interface.cart;

import java.time.LocalDate;
import java.util.List;

import com.restaurant.dto.cart.UpdateShopping;
import com.restaurant.model.document.Product;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.document.ShoppingCart;

import lombok.NonNull;

public interface ShoppingCartServiceInterface {

  public ShoppingCart createShoppingCart();

  public ShoppingCart searchShoppingCartId(String id);

  public ShoppingCart addProducAnShopping(UpdateShopping UpdateShopping);

  public void deleteShopping(@NonNull String idShopping);

  public List<Recipe> getAllRecipe(@NonNull String idShoppingCart);

  public List<Product> getAllProduct(@NonNull String id);

  public List<ShoppingCart> getDateCreation(@NonNull LocalDate dateCreation);
}
