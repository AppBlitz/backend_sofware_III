package com.restaurant.dto.product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.model.Enum.Estate;
import jakarta.annotation.Nullable;
import org.springframework.cglib.core.Local;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Null;
import lombok.NonNull;

public record ProductUpdateDto(@NonNull String id, @NonNull String nameProduct, @NonNull ArrayList<String> suppliers,
                               @NonNull ArrayList<LocalDate> dateExpiration,
                               @NonNull LocalDate dateAdd, double weightProduct, double priceProduct,
                               @Nullable List<MultipartFile> images,@NonNull Estate state, @NonNull
                               String typeStock) {
}
