package com.restaurant.model.vo;

import com.restaurant.model.Enum.RollEmployee;
import lombok.*;

/**
 * The RollForEmployee class represents the role assigned to an employee.
 * It includes information about the employee's role and the permissions associated with that role.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class RollForEmployee {

    /**
     * The role assigned to the employee.
     */
    private RollEmployee rollEmployee;

    /**
     * The permissions associated with the employee's role.
     */
    private Permisions permisions;
}

