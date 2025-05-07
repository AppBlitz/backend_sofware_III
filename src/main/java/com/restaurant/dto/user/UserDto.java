package com.restaurant.dto.user;

import jakarta.validation.constraints.Email;
import lombok.NonNull;

public record UserDto(@NonNull String nameComplet, @Email @NonNull String email) {
}
