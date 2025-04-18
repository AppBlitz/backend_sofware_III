package com.restaurant.model.vo;

import com.restaurant.model.Enum.Objeto;
import com.restaurant.model.Enum.employees.PermisionsCRUD;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.util.HashSet;

/**
 * The Permissions class represents the permissions that employees have.
 * It includes information about the permissions and the objects they are associated with.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class Permissions {

    /**
     * The permissions that employees have.
     */
    @NotNull(message = "Permissions cannot be null")
    @Size(min = 1, message = "There must be at least one permission")
    private HashSet<PermisionsCRUD> permissions;

    /**
     * The object associated with the permissions.
     */
    @NotNull(message = "Object cannot be null")
    private Objeto objeto;
}


