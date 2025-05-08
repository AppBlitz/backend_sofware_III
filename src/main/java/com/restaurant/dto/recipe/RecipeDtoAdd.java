package com.restaurant.dto.recipe;

import java.time.LocalDate;
import java.util.List;

import com.restaurant.model.Enum.Estate;
import com.restaurant.model.vo.Ingredient;
import lombok.*;

public record RecipeDtoAdd(@NonNull String name,
                           @NonNull List<Ingredient> ingredients,
                           @NonNull String instructions,
                           int preparationTime,
                           int servings,
                           String comment,
                           @NonNull LocalDate creationDate) {
}
