package com.restaurant.service.Interface;

import com.restaurant.model.document.Recipe;
import java.util.List;

/**
 * Interface for the recipe management service.
 * Provides methods for performing CRUD operations on recipes.
 */
public interface IRecipeServices {

    /**
     * Creates a new recipe.
     *
     * @param recipe The recipe to create.
     * @return The created recipe.
     */
    Recipe createRecipe(Recipe recipe);

    /**
     * Retrieves a recipe by its ID.
     *
     * @param id The ID of the recipe to retrieve.
     * @return The recipe corresponding to the ID, or null if not found.
     */
    Recipe getRecipeById(String id);

    /**
     * Retrieves all recipes.
     *
     * @return A list of all recipes.
     */
    List<Recipe> getAllRecipes();

    /**
     * Updates an existing recipe.
     *
     * @param id The ID of the recipe to update.
     * @param recipe The updated recipe.
     * @return The updated recipe, or null if the recipe with the provided ID is not found.
     */
    Recipe updateRecipe(String id, Recipe recipe);

    /**
     * Deletes a recipe by its ID.
     *
     * @param id The ID of the recipe to delete.
     */
    void deleteRecipe(String id);
}