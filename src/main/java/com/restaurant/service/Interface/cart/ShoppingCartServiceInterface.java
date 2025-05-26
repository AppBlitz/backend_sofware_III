package com.restaurant.service.Interface.cart;

import java.time.LocalDate;
import java.util.List;

import com.restaurant.dto.cart.SearchCartCategory;
import com.restaurant.dto.cart.UpdateShopping;
import com.restaurant.dto.cart.UpdateStateCartDto;
import com.restaurant.model.document.Product;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.document.ShoppingCart;

import com.restaurant.model.vo.Items;
import lombok.NonNull;

public interface ShoppingCartServiceInterface {

  public ShoppingCart createShoppingCart(List<Items> it,String idwaiteremployee);

  public ShoppingCart searchShoppingCartId(String id);

  public ShoppingCart addProducAnShopping(UpdateShopping UpdateShopping);

  public void deleteShopping(@NonNull String idShopping);

  public List<Recipe> getAllRecipe(@NonNull String idShoppingCart);

  public List<Product> getAllProduct(@NonNull String id);

  public List<ShoppingCart> getDateCreation(@NonNull LocalDate dateCreation);

  public List<ShoppingCart> searchCategory(SearchCartCategory category);

  public void updateCart(UpdateStateCartDto update);
}
