package com.restaurant.model.vo;

import com.restaurant.model.document.Product;
import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Ingredient {
    @NonNull
    Product product;
    @NonNull
    Integer quantity;
    @NonNull
    String unitOfMeasure;
    @NonNull
    String additionalNotes;
}