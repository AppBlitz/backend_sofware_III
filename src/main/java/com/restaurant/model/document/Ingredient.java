package com.restaurant.model.document;

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