package com.restaurant.dto.product;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

public record ProductUpdate(@NonNull String nameProduct, @NonNull String supplier, @NonNull LocalDate dateExpiration,
    @NonNull LocalDate dateAdd, double weightProduct, int amount, double priceProduct, MultipartFile images) {
}
