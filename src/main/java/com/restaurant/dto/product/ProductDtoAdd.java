package com.restaurant.dto.product;

import java.time.LocalDate;
import java.util.List;

import com.restaurant.model.Enum.Estate;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

public record ProductDtoAdd(@NonNull String nameProduct, @NonNull String supplier, /*@NonNull LocalDate dateExpiration,*/
    @NonNull LocalDate dateAdd, double weightProduct, double priceProduct, List<MultipartFile> images, @NonNull
                            Estate state,String typeStock) {
}
