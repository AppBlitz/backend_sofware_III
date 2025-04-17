package com.restaurant.model.document;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * The Sale class represents a sale transaction in the restaurant.
 * It includes information about the sale ID, sale date, total amount, payment method, state, total discount, and invoice.
 */
@AllArgsConstructor
@Document(collection = "sale")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Sale {

    /**
     * The unique identifier for the sale.
     */
    private String saleId;

    /**
     * The date of the sale.
     */
    private LocalDate saleDate;

    /**
     * The total amount of the sale.
     */
    private double totalAmount;

    /**
     * The payment method used for the sale.
     */
    private String paymentMethod;

    /**
     * The state of the sale (e.g., completed, pending).
     */
    private String state;

    /**
     * The total discount applied to the sale.
     */
    private double totalDiscount;

    /**
     * The invoice associated with the sale.
     */
    @NonNull
    private Invoice invoice;
}
