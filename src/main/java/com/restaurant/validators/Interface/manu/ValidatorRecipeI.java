package com.restaurant.validators.Interface.manu;

import java.util.List;

import com.restaurant.model.document.Recipe;
import com.restaurant.model.vo.Items;

public interface ValidatorRecipeI {

  public List<Recipe> getAllRecipe(List<Items> items);
}
