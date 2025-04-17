package com.restaurant.model.vo;

import lombok.*;

/**
 * The Seccion class represents a section in the restaurant.
 * It includes information about the name of the section and the menu items associated with it.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class Seccion {

    /**
     * The name of the section.
     */
    private String nombre;

    /**
     * The menu items associated with the section.
     */
    private MenuItem menuItem;
}

