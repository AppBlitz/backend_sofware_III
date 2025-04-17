package com.restaurant.model.vo;

import com.restaurant.model.document.Product;
import lombok.*;

/**
 * The Ingredient class represents an ingredient used in a product.
 * It includes information about the product ID, quantity, unit of measure, and any additional notes.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class Ingredient {

    /**
     * The unique identifier for the product.
     * This field is mandatory.
     */
    @NonNull
    private String productId;

    /**
     * The quantity of the ingredient.
     * This field is mandatory.
     */
    @NonNull
    private Float quantity;

    /**
     * The unit of measure for the quantity.
     * This field is mandatory.
     */
    @NonNull
    private String unitOfMeasure;

    /**
     * Any additional notes related to the ingredient.
     * This field is mandatory.
     */
    @NonNull
    private String additionalNotes;

    // 200 ok
}
