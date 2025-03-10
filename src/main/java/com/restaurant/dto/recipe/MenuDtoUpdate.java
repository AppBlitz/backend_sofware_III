package com.restaurant.dto.recipe;
import com.restaurant.model.document.Recipe;
import lombok.NonNull;

import java.time.LocalTime;
import java.util.HashMap;


public record MenuDtoUpdate(@NonNull Integer id,
                            @NonNull HashMap<Recipe, Double> menuItems,
                            @NonNull LocalTime date) {
}
