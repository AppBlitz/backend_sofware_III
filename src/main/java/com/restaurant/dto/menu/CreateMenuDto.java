package com.restaurant.dto.menu;

import com.restaurant.model.vo.MenuItem;

import lombok.NonNull;
import java.util.ArrayList;

public record CreateMenuDto(
        @NonNull String name,
        @NonNull String idkitchenEmployee,
        ArrayList<MenuItem> items,
    @NonNull String description) {
}
