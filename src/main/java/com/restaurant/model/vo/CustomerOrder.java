package com.restaurant.model.vo;

import lombok.*;

import java.time.LocalDate;

/**
 * The CustomerOrder class represents an order placed by a customer.
 * It includes information about the customer, the number of products, the status of the order, and the date of the order.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class CustomerOrder {

    /**
     * The unique identifier for the customer.
     */
    private String customerID;

    /**
     * The number of products in the order.
     */
    private int amountProducts;

    /**
     * The status of the order (e.g., pending, shipped, delivered).
     */
    private String orderStatus;

    /**
     * The date when the order was placed.
     */
    private LocalDate orderDate;

    /**
     * The menu item associated with the order.
     */
    private MenuItem menuItem;
}
