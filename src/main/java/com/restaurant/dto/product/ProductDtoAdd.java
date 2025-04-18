package com.restaurant.dto.product;

import java.time.LocalDate;
import java.util.List;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

public record ProductDtoAdd(@NonNull String nameProduct, @NonNull String supplier, /*@NonNull LocalDate dateExpiration,*/
    @NonNull LocalDate dateAdd, double weightProduct, int amount, double priceProduct, @Null List<MultipartFile> images,    @NonNull
                            String typeStock) {
}
