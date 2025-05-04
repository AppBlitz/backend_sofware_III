package com.restaurant.dto.cart;

import java.util.ArrayList;

import com.restaurant.model.Enum.cart.StateCart;
import com.restaurant.model.document.Menu;

import jakarta.validation.constraints.Null;
import lombok.NonNull;

public record AddProductDto(@Null String id, @NonNull StateCart stateCart, @NonNull ArrayList<Menu> menus,
    double total) {
}
