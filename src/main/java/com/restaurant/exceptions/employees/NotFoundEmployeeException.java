package com.restaurant.exceptions.employees;

public class NotFoundEmployeeException extends Exception {
    public NotFoundEmployeeException(String message) {
        super(message);
    }
}
