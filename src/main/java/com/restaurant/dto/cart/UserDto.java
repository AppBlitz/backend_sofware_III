package com.restaurant.dto.cart;

import jakarta.validation.constraints.Email;
import lombok.NonNull;

public record UserDto(@NonNull String name, @NonNull @Email String email) {
}
