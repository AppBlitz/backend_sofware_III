package com.restaurant.model.document;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.restaurant.model.Enum.cart.StateCart;

import lombok.*;

@Setter
@ToString
@Getter
@Builder
@Document(collection = "cart")
public class ShoppingCart {

  @Id
  String id;

  @Builder.Default
  ArrayList<Menu> menus = new ArrayList<>();

  @NonNull
  StateCart stateCart;

  int amount;

  double total;

}
