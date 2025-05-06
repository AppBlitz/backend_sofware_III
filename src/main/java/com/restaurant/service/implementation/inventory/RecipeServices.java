package com.restaurant.service.implementation.inventory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dto.recipe.RecipeDtoUpdate;
import com.restaurant.exceptions.recipe.runTime.RecipeExceptionServings;
import com.restaurant.exceptions.recipe.runTime.RecipeExceptionUpdate;
import com.restaurant.model.Enum.Estate;
import com.restaurant.model.document.Recipe;
import com.restaurant.model.vo.HistoryRecipe;
import com.restaurant.repository.HistoryRecipeRepository;
import com.restaurant.repository.RecipeRepository;
import com.restaurant.service.Interface.inventory.IRecipeServices;

/**
 * Implementation of the recipe management service.
 * Provides methods to perform CRUD operations on recipes.
 */
@Service
public class RecipeServices implements IRecipeServices {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private HistoryRecipeRepository historyRecipeRepository;

    /**
     * Creates a new recipe.
     *
     * @param recipe The recipe to create.
     * @return The created recipe.
     */
    @Override
    public Recipe createRecipe(Recipe recipe) {
        HistoryRecipe historyRecipe = new HistoryRecipe("CREACION", LocalDateTime.now(),
                "se registra la creacion de una nueva receta en el sistema llamada: " + recipe.getName());
        historyRecipeRepository.save(historyRecipe);
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
     * @param id     The ID of the recipe to update.
     * @param recipe The updated recipe.
     * @return The updated recipe, or null if the recipe with the provided ID is not
     *         found.
     */

    /**
     * Deletes a recipe by its ID.
     *
     * @param id The ID of the recipe to delete.
     */
    @Override
    public void deleteRecipe(String id) {
        // recipeRepository.deleteById(id);
        Recipe recipe = getRecipeById(id);
        recipe.setEstate(Estate.INACTIVE);
        HistoryRecipe historyRecipe = new HistoryRecipe("deleted", LocalDateTime.now(),
                "se registra la desactivacion de una receta en el sistema llamada: " + recipe.getName());
        historyRecipeRepository.save(historyRecipe);
        recipeRepository.save(recipe);
    }

    public List<HistoryRecipe> consult_movementsByDate(LocalDate date) {
        LocalDateTime start = date.atStartOfDay();
        LocalDateTime end = date.plusDays(1).atStartOfDay();
        return historyRecipeRepository.findByTimestampBetween(start, end);

    }

    public List<HistoryRecipe> consult_movementsByHour(LocalDate date, int startHour, int endHour) {
        LocalDateTime start = date.atTime(startHour, 0);
        LocalDateTime end = date.atTime(endHour, 0);
        return historyRecipeRepository.findByTimestampBetween(start, end);
    }

    @Override
    public void uptadesServingsRecipe(String id, int amount) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        if (recipe.isEmpty())
            throw new RecipeExceptionServings("Unimplemented method 'uptadesServingsRecipe'");
        Recipe update = recipe.get();
        update.setServings(recipe.get().getServings());
        recipeRepository.save(update);
    }

    @Override
    public void uptadedRecipeCount(String id, int count) {
        Recipe recipe = recipeRepository.findById(id).get();

        Recipe updatedRecipe = recipe;
        updatedRecipe.setEstate(recipe.getEstate());
        updatedRecipe.setName(recipe.getName());
        updatedRecipe.setIngredients(recipe.getIngredients());
        updatedRecipe.setInstructions(recipe.getInstructions());
        updatedRecipe.setPreparationTime(recipe.getPreparationTime());
        updatedRecipe.setServings(recipe.getServings() - count);
        updatedRecipe.setComment(recipe.getComment());
        updatedRecipe.setCreationDate(recipe.getCreationDate());
        updatedRecipe.setPrice(recipe.getPrice());
        recipeRepository.save(updatedRecipe);
    }

    @Override
    public Recipe updateRecipe(RecipeDtoUpdate recipeUpdate) {
        Optional<Recipe> recipe = recipeRepository.findById(recipeUpdate.id());
        if (recipe.isEmpty())
            throw new RecipeExceptionUpdate("The recipe not found");

        Recipe update = recipe.get();
        update.setName(recipeUpdate.name());
        update.setEstate(recipeUpdate.recipeStatus());
        update.setPreparationTime(recipeUpdate.preparationTime());
        update.setCreationDate(recipeUpdate.creationDate());
        update.setInstructions(recipeUpdate.instructions());
        update.setIngredients(recipeUpdate.ingredients());
        update.setComment(recipeUpdate.comment());
        update.setPrice(recipeUpdate.price());
        update.setServings(recipeUpdate.servings());
        return recipeRepository.save(update);
    }

}
