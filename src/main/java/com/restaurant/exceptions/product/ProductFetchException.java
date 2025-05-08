package com.restaurant.exceptions.product;

/**
 * Exception thrown when there is an error fetching a product.
 */
public class ProductFetchException extends RuntimeException {

    /**
     * Constructs a new ProductFetchException with the specified detail message.
     *
     * @param message the detail message.
     */
    public ProductFetchException(String message) {
        super("Error fetching product:\n" + message);
    }

    /**
     * Constructs a new ProductFetchException with a default message.
     */
    public ProductFetchException() {
        super("Error fetching product");
    }
}
