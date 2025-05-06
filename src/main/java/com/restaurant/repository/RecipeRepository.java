package com.restaurant.repository;

import java.util.List;
import java.util.Optional;

import com.restaurant.model.Enum.Estate;
import com.restaurant.model.document.Recipe;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Recipe documents.
 * Provides methods for CRUD operations and custom queries.
 */
@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {

    /**
     * Finds a recipe by its name.
     *
     * @param name The name of the recipe to find.
     * @return An Optional containing the found recipe, or empty if no recipe is
     *         found.
     */
    @Query("{ 'name' : ?0}")
    Optional<Recipe> findByName(@NonNull String name);

    /**
     * Finds a recipe by its status.
     *
     * @param recipeStatus The status of the recipe to find.
     * @return An Optional containing the found recipe, or empty if no recipe is
     *         found.
     */
    @Query("{ 'state' : ?0}")
    Optional<Recipe> findByEstate(@NonNull Estate estate);

    @Query("{ '_id' : ?0 }")
    Optional<Recipe> findById(@NonNull String id);

    @Query(" { 'state' : ?0 }")
    List<Recipe> findByRecipes(@NonNull Estate state);

}
