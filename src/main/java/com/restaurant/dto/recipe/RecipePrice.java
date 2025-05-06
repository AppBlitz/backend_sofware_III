package com.restaurant.dto.recipe;

import lombok.NonNull;

public record RecipePrice(@NonNull String id, @NonNull String name, int servings, double price) {
}
