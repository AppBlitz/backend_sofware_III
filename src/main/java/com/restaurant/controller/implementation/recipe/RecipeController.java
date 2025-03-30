package com.restaurant.controller.implementation.recipe;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restaurant.controller.Interface.recipe.RecipeControllerInterface;
import com.restaurant.dto.recipe.RecipeDtoAdd;
import com.restaurant.dto.recipe.RecipeDtoUpdate;
import com.restaurant.model.document.Recipe;
import com.restaurant.service.implementation.RecipeServices;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/recipes")

public class RecipeController implements RecipeControllerInterface {

    @Autowired
    private RecipeServices recipeServices;

    @Override
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Recipe> createRecipe(@Valid @RequestBody RecipeDtoAdd recipeDtoAdd) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDtoAdd.name());
        recipe.setIngredients(recipeDtoAdd.ingredients());
        recipe.setInstructions(recipeDtoAdd.instructions());
        recipe.setPreparationTime(recipeDtoAdd.preparationTime());
        recipe.setServings(recipeDtoAdd.servings());
        recipe.setComment(recipeDtoAdd.comment());
        recipe.setCreationDate(recipeDtoAdd.creationDate());
        recipe.setRecipeStatus(recipeDtoAdd.recipeStatus());
        Recipe newRecipe = recipeServices.createRecipe(recipe);
        return ResponseEntity.status(200).body(newRecipe);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Recipe> getRecipeById(@PathVariable String id) {
        Recipe recipe = recipeServices.getRecipeById(id);
        if (recipe != null) {
            return ResponseEntity.ok(recipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        List<Recipe> recipes = recipeServices.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Recipe> updateRecipe(@PathVariable String id,
            @Valid @RequestBody RecipeDtoUpdate recipeDtoUpdate) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeDtoUpdate.name());
        recipe.setIngredients(recipeDtoUpdate.ingredients());
        recipe.setInstructions(String.valueOf(recipeDtoUpdate.instructions()));
        recipe.setPreparationTime(recipeDtoUpdate.preparationTime());
        recipe.setServings(recipeDtoUpdate.servings());
        recipe.setComment(recipeDtoUpdate.comment());
        recipe.setCreationDate(LocalDate.from(recipeDtoUpdate.creationDate()));
        recipe.setRecipeStatus(String.valueOf(recipeDtoUpdate.recipeStatus()));
        Recipe updatedRecipe = recipeServices.updateRecipe(id, recipe);
        if (updatedRecipe != null) {
            return ResponseEntity.ok(updatedRecipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteRecipe(@PathVariable String id) {
        recipeServices.deleteRecipe(id);
        return ResponseEntity.noContent().build();
    }
}
