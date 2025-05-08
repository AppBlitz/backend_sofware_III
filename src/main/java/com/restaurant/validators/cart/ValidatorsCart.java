package com.restaurant.validators.cart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.restaurant.model.vo.Items;
import com.restaurant.service.implementation.inventory.ProductService;
import com.restaurant.service.implementation.inventory.RecipeServices;
import com.restaurant.validators.Interface.cart.ValidatorsCartInt;

@Component
public class ValidatorsCart implements ValidatorsCartInt {

  @Autowired
  ProductService productService;

  @Autowired
  RecipeServices recipeServices;

  @Override
  public void modificationData(ArrayList<Items> items) {
    for (Items item : items) {
      if (item.getMenuItem().getProduct().isEmpty()) {
        modificationRecipe(item.getMenuItem().getRecipe(), item.getAmountServings(), item.getRestServings());
      } else {
        modificationProduct(item.getMenuItem().getProduct(), item.getAmountServings(), item.getRestServings());
      }
    }
  }

  @Override
  public void modificationProduct(String idProduct, int amount, int rest) {
    if (amount >= 1 && rest == 0) {
      productService.resProduct(idProduct, amount);
    } else {
      if (rest > 0) {
        productService.sumStock(idProduct, rest);
      }
    }
  }

  @Override
  public void modificationRecipe(String idRecipe, int amount, int rest) {
    if (amount >= 1 && rest == 0) {
      recipeServices.restAmount(idRecipe, amount);
    } else {
      if (rest > 0 && amount == 0) {
        recipeServices.sumServings(idRecipe, rest);
      }
    }
  }

}
