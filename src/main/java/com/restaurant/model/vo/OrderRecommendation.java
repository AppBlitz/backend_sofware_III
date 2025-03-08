package com.restaurant.model.vo;

import com.restaurant.model.document.Product;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Allows for a builder pattern to create instances of this class

public class OrderRecommendation {

    @NonNull //marks that the field cannot be empty
    private LocalDate date; //current date

    @NonNull //marks that the field cannot be empty
    private List<Product> products; //list of products that the order will contain

}