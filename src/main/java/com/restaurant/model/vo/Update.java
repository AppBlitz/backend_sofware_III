package com.restaurant.model.vo;

import com.restaurant.model.Enum.UpdateType;
import lombok.*;

import java.time.LocalDate;

/**
 * The Update class represents an update in the system.
 * It includes information about the type of update, the date of the update, the amount involved, and a description of the update.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class Update {

    /**
     * The type of update.
     */
    private UpdateType updateType;

    /**
     * The date of the update.
     */
    private LocalDate updateDate;

    /**
     * The amount involved in the update.
     */
    private double amount;

    /**
     * A description of the update.
     */
    private String description;
}
