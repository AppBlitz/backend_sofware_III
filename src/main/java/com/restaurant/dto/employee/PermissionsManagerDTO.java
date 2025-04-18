package com.restaurant.dto.employee;

import com.restaurant.model.Enum.Objeto;
import com.restaurant.model.Enum.employees.PermisionsCRUD;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;

public record PermissionsManagerDTO(
        @NotBlank
        String managerID,
        @NotNull(message = "Permissions cannot be null")
        @Size(min = 1, message = "There must be at least one permission")
        HashSet<PermisionsCRUD> permissions,
        @NotNull(message = "Object cannot be null")
        Objeto objeto
) {}
