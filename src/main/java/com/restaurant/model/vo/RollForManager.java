package com.restaurant.model.vo;

import com.restaurant.model.Enum.employees.RollManager;
import lombok.*;

/**
 * The RollForManager class represents the role assigned to a manager.
 * It includes information about the manager's role and the permissions associated with that role.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class RollForManager {

    /**
     * The role assigned to the manager.
     */
    private RollManager rollManagment;

    /**
     * The permissions associated with the manager's role.
     */
    private Permisions permisions;
}
