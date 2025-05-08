package com.restaurant.dto.cart;

import com.restaurant.model.Enum.CategoriItem;

import lombok.NonNull;

public record SearchShoppingCartCategory(@NonNull String id, @NonNull CategoriItem category) {
}
