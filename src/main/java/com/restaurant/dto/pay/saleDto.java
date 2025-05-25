package com.restaurant.dto.pay;

import lombok.NonNull;

import java.time.LocalDateTime;

public record saleDto(
        @NonNull
        String idShoppingCart,
        @NonNull
        String idCashier,
        @NonNull
        LocalDateTime date,
        @NonNull
        String paymentMethod,
        @NonNull
        double amount) {
}
