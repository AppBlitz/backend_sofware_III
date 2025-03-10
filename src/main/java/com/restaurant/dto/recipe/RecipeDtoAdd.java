package com.restaurant.dto.recipe;

import java.time.LocalDate;
import java.util.List;

import com.restaurant.model.vo.Ingredient;
import lombok.*;

public record RecipeDtoAdd(@NonNull String name, @NonNull List<Ingredient> ingredients, @NonNull String instructions,
                           @NonNull int preparationTime, @NonNull int servings, String comment,
                           @NonNull LocalDate creationDate, @NonNull String recipeStatus) {
}