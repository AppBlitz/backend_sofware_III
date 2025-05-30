package com.restaurant.service.Interface.inventory;

import java.util.List;

import com.restaurant.dto.recipe.RecipeDtoUpdate;
import com.restaurant.dto.recipe.RecipePrice;
import com.restaurant.model.Enum.Estate;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.vo.Items;

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
     * @param id     The ID of the recipe to update.
     * @param recipe The updated recipe.
     * @return The updated recipe, or null if the recipe with the provided ID is not
     *         found.
     */
    Recipe updateRecipe(RecipeDtoUpdate recipeUpdate);

    /**
     * Deletes a recipe by its ID.
     *
     * @param id The ID of the recipe to delete.
     */
    void deleteRecipe(String id);

    public void uptadesServingsRecipe(String id, int amount);

    public void uptadedRecipeCount(String id, int count);

    public List<RecipePrice> getAllRecipeActivate(Estate state);

    public void modificationDataRecipe(String id, int amount, int rest);

    public boolean verificationRecipeExists(String id);

    public void sumServings(String idRecipe, int restSrvings);

    public void restAmount(String idRecipe, int amount);

    public List<Recipe> listAllRecipe(List<Items> productsOrArecipe);

    public List<RecipePrice> getAllRecipePrice();
}
