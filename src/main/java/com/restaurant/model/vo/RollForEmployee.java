package com.restaurant.model.vo;

import com.restaurant.model.Enum.employees.RollEmployee;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.ArrayList;

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
    @NotNull(message = "Role employee cannot be null")
    private RollEmployee rollEmployee;

    /**
     * The permissions associated with the employee's role.
     */
    @NotNull(message = "Permissions cannot be null")
    @Size(min = 1, message = "There must be at least one permission")
    private ArrayList<Permissions> permissions;
}
