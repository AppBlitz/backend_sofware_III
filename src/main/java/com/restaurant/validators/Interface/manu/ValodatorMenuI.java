package com.restaurant.validators.Interface.manu;

import java.util.List;

import com.restaurant.model.document.Recipe;
import com.restaurant.model.vo.Items;

public interface ValodatorMenuI {

  public List<Recipe> searchRecipe(List<Items> item);

}
