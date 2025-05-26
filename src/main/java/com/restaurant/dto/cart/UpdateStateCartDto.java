package com.restaurant.dto.cart;

import com.restaurant.model.Enum.cart.StateCart;

import lombok.NonNull;

public record UpdateStateCartDto(@NonNull String id, @NonNull StateCart stateCart) {
}
