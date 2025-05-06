package com.restaurant.dto.recipe;

import java.time.LocalDate;
import java.util.HashMap;

import com.restaurant.model.document.Recipe;

import lombok.NonNull;

public record MenuDtoAdd(@NonNull HashMap<String, Recipe> menuItems,
                                                                                                                                                @NonNull LocalDate date) {
}
