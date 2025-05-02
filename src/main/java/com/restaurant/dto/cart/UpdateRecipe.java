package com.restaurant.dto.cart;

import lombok.NonNull;

public record UpdateRecipe(@NonNull String id, int amount) {
}
