package com.restaurant.model.vo;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

/**
 * The Pay class represents a payment.
 * It includes information about the date and the amount of the payment.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class Pay {

    /**
     * The date of the payment.
     */
    private LocalDate date;

    /**
     * The amount of the payment.
     */
    private Double amount;
}
