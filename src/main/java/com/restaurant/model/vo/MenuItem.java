package com.restaurant.model.vo;

import com.restaurant.model.Enum.CategoriItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The MenuItem class represents an item on the restaurant's menu.
 * It includes information about the product and the recipe.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class MenuItem {

    /**
     * The product associated with the menu item.
     */
    @Builder.Default
    private String recipe = "";

    @Builder.Default
    private String product = "";

    @lombok.NonNull
    CategoriItem categoriItem;
}
