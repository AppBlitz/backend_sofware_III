package com.restaurant.validators.menu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.restaurant.model.document.Recipe;
import com.restaurant.model.vo.Items;
import com.restaurant.service.implementation.inventory.RecipeServices;
import com.restaurant.validators.Interface.manu.ValidatorRecipeI;

@Component
public class ValidatorRecipe implements ValidatorRecipeI {

  @Autowired
  @Lazy
  RecipeServices rServices;

  @Override
  public List<Recipe> getAllRecipe(List<Items> items) {
    List<Recipe> recipes = new ArrayList<>();
    for (Items item : items) {
      if (!item.getMenuItem().getRecipe().isEmpty()) {
        recipes.add(rServices.getRecipeById(item.getMenuItem().getRecipe()));
      }
    }
    return recipes;
  }

}
