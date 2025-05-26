package com.restaurant.model.document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.restaurant.model.Enum.cart.StateCart;
import com.restaurant.model.vo.Items;

import lombok.*;

@Setter
@ToString
@Getter
@Builder
@Document(collection = "cart")
public class ShoppingCart {

  @Id
  String id;


  String idwaiteremployee;

  @NonNull
  LocalDate dateCreation;

  @Builder.Default
  List<Items> items = new ArrayList<>();

  @NonNull
  StateCart stateCart;

}
