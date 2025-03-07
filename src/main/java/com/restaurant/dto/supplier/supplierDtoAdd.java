package com.restaurant.dto.supplier;

import com.restaurant.enums.StateEnum;
import com.restaurant.model.document.Product;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

public record supplierDtoAdd(@NonNull String name,
                             @NonNull String location,
                             @NonNull LocalDate orderDate,
                             @NonNull List<Product>offeredProducts,
                             @NonNull StateEnum stateAtivity) {
}
