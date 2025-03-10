package com.restaurant.model.vo;

import com.restaurant.model.document.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @NonNull
    String productId;
    @NonNull
    Integer quantity;
    @NonNull
    String unitOfMeasure;
    @NonNull
    String additionalNotes;
}