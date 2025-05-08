package com.restaurant.controller.Interface.recipe;
import com.restaurant.dto.recipe.RecipeDtoAdd;
import com.restaurant.dto.recipe.RecipeDtoUpdate;
import com.restaurant.model.document.Recipe;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RecipeControllerInterface {

    ResponseEntity<Recipe> createRecipe(RecipeDtoAdd recipeDtoAdd);

    ResponseEntity<Recipe> getRecipeById(String id);

    ResponseEntity<List<Recipe>> getAllRecipes();

    ResponseEntity<Recipe> updateRecipe(String id, RecipeDtoUpdate recipeDtoUpdate);

    ResponseEntity<Void> deleteRecipe(String id);
}