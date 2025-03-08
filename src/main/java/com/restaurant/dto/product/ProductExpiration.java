package com.restaurant.dto.product;

import java.time.LocalDate;

import lombok.NonNull;

public record ProductExpiration(@NonNull String nameProduct, @NonNull LocalDate dateEXpiration) {
}
