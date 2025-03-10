package com.restaurant.dto.product;

import java.time.LocalDate;

import lombok.*;

public record ProductDtoAdd(@NonNull String nameProduct, @NonNull String supplier, @NonNull LocalDate dateExpiration, @NonNull LocalDate dateAdd,double weightProduct,int amount,double priceProduct) {
}
