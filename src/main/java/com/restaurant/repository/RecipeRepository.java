package com.restaurant.repository;

import java.util.Optional;

import com.restaurant.Enum.RecipeStatus;
import com.restaurant.model.document.Recipe;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Recipe documents.
 * Provides methods for CRUD operations and custom queries.
 */
@Repository
public interface RecipeRepository extends MongoRepository<Recipe, Integer> {

    /**
     * Finds a recipe by its name.
     *
     * @param name The name of the recipe to find.
     * @return An Optional containing the found recipe, or empty if no recipe is found.
     */
    Optional<Recipe> findByName(@NonNull String name);

    /**
     * Finds a recipe by its status.
     *
     * @param recipeStatus The status of the recipe to find.
     * @return An Optional containing the found recipe, or empty if no recipe is found.
     */
    Optional<Recipe> findByRecipeStatus(@NonNull RecipeStatus recipeStatus);
}