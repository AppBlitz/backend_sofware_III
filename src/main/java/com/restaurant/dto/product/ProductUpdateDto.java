package com.restaurant.dto.product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Null;
import lombok.NonNull;

public record ProductUpdateDto(@NonNull String id, @NonNull String nameProduct, @NonNull ArrayList<String> suppliers,
                @NonNull LocalDate dateExpiration,
                @NonNull LocalDate dateAdd, double weightProduct, int amount, double priceProduct,
                @Null List<MultipartFile> images) {
}
