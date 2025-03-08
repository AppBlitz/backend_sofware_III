package com.restaurant.model.vo;
import com.restaurant.model.document.Supplier;
import lombok.*;

import java.util.ArrayList;

@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Allows for a builder pattern to create instances of this class
public class ProductRecommendation {

    @NonNull //marks that the field cannot be empty
    private String productName; //name of the product we are going to order

    private int currentStock; //current product quantity

    private int recommendedQuantity; //recommended order quantity

    @NonNull //marks that the field cannot be empty
    private ArrayList<String> suppliersName; // supplier´s name

}
