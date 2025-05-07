package com.restaurant.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Items {

  @NonNull
  MenuItem menuItem;

  int amountServings;

  int restServings;
}
