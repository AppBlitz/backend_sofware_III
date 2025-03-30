package com.restaurant.dto.product;

import java.time.LocalDate;
import java.util.ArrayList;

import lombok.NonNull;

public record ListProducts(@NonNull String nameProduct, double priceProduct, int stock,
        @NonNull ArrayList<String> idSupplier,
        @NonNull LocalDate dateExpiration, @NonNull LocalDate dateRegister, double weightProduct) {

}
