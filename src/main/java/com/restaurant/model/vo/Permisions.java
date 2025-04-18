package com.restaurant.model.vo;

import com.restaurant.model.Enum.Objeto;
import com.restaurant.model.Enum.employees.PermisionsCRUD;
import lombok.*;
import java.util.HashSet;

/**
 * The Permisions class represents the permissions that employees have.
 * It includes information about the permissions and the objects they are associated with.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class Permisions {

    /**
     * The permissions that employees have.
     */
    private HashSet<PermisionsCRUD> permisos;

    /**
     * The object associated with the permissions.
     */
    private Objeto objeto;
}

