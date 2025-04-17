package com.restaurant.model.vo;

import lombok.*;

/**
 * The InvoiceDetails class represents the details of an invoice.
 * It includes information about the product, quantity, price, and any discounts applied.
 */
@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Enables the builder pattern for creating instances of the class
public class InvoiceDetails {

    /**
     * The unique identifier for the invoice detail.
     */
    private String idInvoiceDetail;

    /**
     * The name of the product.
     */
    private String nameProduct;

    /**
     * The quantity of the product.
     */
    private int quantityProduct;

    /**
     * Any additional notes related to the invoice detail.
     */
    private String notes;

    /**
     * The price of the product.
     */
    private double priceProduct;

    /**
     * The discount applied to the product.
     */
    private double discountProduct;

    /**
     * The customer order associated with the invoice detail.
     */
    private CustomerOrder customerOrder;
}
