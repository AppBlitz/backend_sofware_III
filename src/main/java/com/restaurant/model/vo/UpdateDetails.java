package com.restaurant.model.vo;

import com.restaurant.model.document.Employee;
import lombok.*;

import java.util.List;

/**
 * The UpdateDetails class represents the details of an update.
 * It includes information about the list of updates and the employee associated with the updates.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class UpdateDetails {

    /**
     * The list of updates.
     */
    private List<Update> updates;

    /**
     * The employee associated with the updates.
     */
    private Employee employee;
}
