package com.restaurant.dto.product;

import lombok.NonNull;

public record ProductActiveDto(@NonNull String id, double price, @NonNull String nameProduct, int stock) {
}
