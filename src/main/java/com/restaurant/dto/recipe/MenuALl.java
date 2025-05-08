package com.restaurant.dto.recipe;

import java.time.LocalDate;

import lombok.NonNull;

public record MenuALl(@NonNull String id, @NonNull String name, @NonNull LocalDate date) {
}
