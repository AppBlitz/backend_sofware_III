package com.restaurant.dto.product;

import com.restaurant.model.Enum.MovementAction;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record MovementDto( @NonNull MovementAction action, int amount, @NonNull String reason, LocalDateTime timestamp, LocalDate expiration) {
}
