package com.restaurant.exceptions.cart;

public class UpdatedRecipeServingsExceptions extends RuntimeException {

  public UpdatedRecipeServingsExceptions(String message) {
    super(message);
  }

  public UpdatedRecipeServingsExceptions() {
    super("Recipe not updated ");
  }
}
