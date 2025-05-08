package com.restaurant.exceptions.cart;

public class SearchCartException extends RuntimeException {
  public SearchCartException() {
    super("Not found succesfully cart" + "\n");
  }

  public SearchCartException(String message) {
    super(message);
  }
}
