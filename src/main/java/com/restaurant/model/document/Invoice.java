package com.restaurant.model.document;

import com.restaurant.model.vo.InvoiceDetails;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * The Invoice class represents an invoice in the restaurant system.
 * It includes information about the invoice ID, payment status, invoice date, taxes, total discounts, and invoice details.
 */
@AllArgsConstructor
@Document(collection = "invoice")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Invoice {

    /**
     * The unique identifier for the invoice.
     */
    private String idVoice;

    /**
     * The payment status of the invoice.
     */
    private String paymentStatus;

    /**
     * The date of the invoice.
     */
    private LocalDate invoiceDate;

    /**
     * The taxes applied to the invoice.
     */
    private double taxes;

    /**
     * The total discounts applied to the invoice.
     */
    private double totalDiscounts;

    /**
     * The details of the invoice.
     */
    private InvoiceDetails invoiceDetails;
}
