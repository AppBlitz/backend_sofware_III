package com.restaurant.model.vo;

import com.restaurant.model.Enum.MovementAction;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Allows for a builder pattern to create instances of this class

public class MovementProduct {

    @NonNull
    private String nameProduct;
    @NonNull
    private MovementAction action;//action in the system

    private int amount;//quantity that reteired or ingresed
    @NonNull
    private String reason;//the reason for that action
    @NonNull
    private LocalDateTime timestamp;//date and time
    @NonNull
    private LocalDate expiration;//date of expiration of product


}
