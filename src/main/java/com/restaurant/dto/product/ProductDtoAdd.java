package com.restaurant.dto.product;

import java.util.Date;

import lombok.*;

public record ProductDtoAdd(@NonNull String nameProduct, @NonNull String supplier, @NonNull Date dateExpiration,
    @NonNull Date dateAdd, int weightProductm, int amount) {
}
