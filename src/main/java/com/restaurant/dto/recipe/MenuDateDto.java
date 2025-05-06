package com.restaurant.dto.recipe;

import java.time.LocalDate;

import lombok.NonNull;

public record MenuDateDto(@NonNull LocalDate date) {
}
