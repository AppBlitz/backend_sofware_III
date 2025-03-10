package com.restaurant.service.implementation;

import com.restaurant.model.document.Recipe;
import com.restaurant.repository.RecipeRepository;
import com.restaurant.service.Interface.IRecipeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the recipe management service.
 * Provides methods to perform CRUD operations on recipes.
 */
@Service
public class RecipeServices implements IRecipeServices {

    @Autowired
    private RecipeRepository recipeRepository;

    /**
     * Creates a new recipe.
     *
     * @param recipe The recipe to create.
     * @return The created recipe.
     */
    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    /**
     * Gets a recipe by its ID.
     *
     * @param id The ID of the recipe to get.
     * @return The recipe corresponding to the ID, or null if not found.
     */
    @Override
    public Recipe getRecipeById(String id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipe.orElse(null);
    }

    /**
     * Gets all recipes.
     *
     * @return A list of all recipes.
     */
    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    /**
     * Updates an existing recipe.
     *
     * @param id The ID of the recipe to update.
     * @param recipe The updated recipe.
     * @return The updated recipe, or null if the recipe with the provided ID is not found.
     */
    @Override
    public Recipe updateRecipe(String id, Recipe recipe) {
        if (recipeRepository.existsById(id)) {
            recipe.setId(id);
            return recipeRepository.save(recipe);
        }
        return null;
    }

    /**
     * Deletes a recipe by its ID.
     *
     * @param id The ID of the recipe to delete.
     */
    @Override
    public void deleteRecipe(String id) {
        recipeRepository.deleteById(id);
    }
}