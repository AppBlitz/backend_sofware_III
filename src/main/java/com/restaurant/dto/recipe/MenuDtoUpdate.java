package com.restaurant.dto.recipe;

import java.time.LocalDate;
import java.util.HashMap;

import com.restaurant.model.document.Recipe;

import lombok.NonNull;

public record MenuDtoUpdate(@NonNull Integer id,
                                                                                                                                                @NonNull HashMap<String, Recipe> menuItems,
                                                                                                                                                @NonNull LocalDate date) {
}
