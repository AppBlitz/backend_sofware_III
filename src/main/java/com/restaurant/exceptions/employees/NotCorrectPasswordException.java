package com.restaurant.exceptions.employees;

public class NotCorrectPasswordException extends Exception {
    public NotCorrectPasswordException(String message) {
        super(message);
    }
}
