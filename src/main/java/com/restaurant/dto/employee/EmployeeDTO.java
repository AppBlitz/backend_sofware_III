package com.restaurant.dto.employee;

import com.restaurant.model.Enum.employees.RollEmployee;
import com.restaurant.model.document.Employee;
import com.restaurant.model.vo.RollForEmployee;
import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.HashMap;

public record EmployeeDTO(
        @Id
        String id,
        @NotBlank(message = "Employee name cannot be blank")
        String nameEmployee,
        @NotBlank(message = "Address cannot be blank")
        String address,
        @NotBlank(message = "City cannot be blank")
        String city,
        @NotBlank(message = "Phone number cannot be blank")
        @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
        String phoneNumber,
        @NotBlank(message = "Entry date cannot be null")
        LocalDate entryDate,
        //retirementDate can be null
        LocalDate retirementDate,
        @NotNull(message = "Retirement status cannot be null")
        double baseSalary,
        RollEmployee roll,
        @Email
        @NotBlank
        String email,
        @NotBlank
        @Size(min = 8, message = "Password must be at least 8 characters long")
        String password,
        // Attributes from enum
        @NotNull
        HashMap<Employee.Day, Employee.Hours>schedule
) {}