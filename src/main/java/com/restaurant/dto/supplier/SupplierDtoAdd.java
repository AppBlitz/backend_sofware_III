package com.restaurant.dto.supplier;

import com.restaurant.model.Enum.StateEnum;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

public record SupplierDtoAdd(@NonNull String nameSupplier,
                             @NonNull String location,
                             @NonNull LocalDate orderDate,
                             @NonNull List<String>offeredProducts,
                             @NonNull StateEnum stateActivity) {
}
