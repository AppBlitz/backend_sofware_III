package com.restaurant.model.vo;

import com.restaurant.model.document.Product;
import com.restaurant.model.document.Recipe;
import lombok.*;

/**
 * The MenuItem class represents an item on the restaurant's menu.
 * It includes information about the product and the recipe.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class MenuItem {

    /**
     * The product associated with the menu item.
     */
    private Product product;

    /**
     * The recipe for the menu item.
     */
    private Recipe recipe;
}
