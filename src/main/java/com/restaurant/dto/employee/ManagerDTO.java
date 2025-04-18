package com.restaurant.dto.employee;

import com.restaurant.model.vo.RollForManager;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

public record ManagerDTO(
        @Id
        @NotBlank
        @NotNull(message = "Wrapped employee cannot be null")
        String wrappeID,
        @NotNull(message = "Role manager cannot be null")
        RollForManager rollManager,
        @Min(value = 0, message = "Increment salary must be positive")
        Double incrementSalary
) {
}
