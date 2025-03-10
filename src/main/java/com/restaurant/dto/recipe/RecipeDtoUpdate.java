package com.restaurant.dto.recipe;
import com.restaurant.model.Enum.RecipeStatus;
import com.restaurant.model.vo.Ingredient;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

public record RecipeDtoUpdate(@NonNull String id,
                              @NonNull String name, @NonNull List<Ingredient> ingredients, @NonNull String instructions,
                              @NonNull int preparationTime, @NonNull int servings, String comment,
                              @NonNull LocalDate creationDate, @NonNull String recipeStatus) {
}
