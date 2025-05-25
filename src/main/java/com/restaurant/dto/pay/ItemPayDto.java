package com.restaurant.dto.pay;

import com.restaurant.model.Enum.CategoriItem;
import com.restaurant.model.vo.MenuItem;
import lombok.NonNull;

public record ItemPayDto(
        @NonNull MenuItem menuItem,
        Integer restServings,
        @NonNull Integer amountServings) {
}
