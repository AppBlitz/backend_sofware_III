package com.restaurant.dto.cart;

import com.restaurant.model.Enum.cart.StateCart;

import lombok.NonNull;

public record SearchCartCategory(@NonNull StateCart stateCart) {
}
