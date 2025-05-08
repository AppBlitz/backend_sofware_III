package com.restaurant.dto.employee;

import java.time.LocalDate;

import com.restaurant.model.Enum.employees.RollEmployee;
import org.springframework.data.annotation.Id;

import com.restaurant.model.document.Employee;
import com.restaurant.model.vo.RollForEmployee;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashMap;

public record EmployeeDTO(

                @Null @Id String id,
                @NotBlank(message = "Employee name cannot be blank") String nameEmployee,
                @NotBlank(message = "Address cannot be blank") String address,
                @NotBlank(message = "City cannot be blank") String city,
                @NotBlank(message = "Phone number cannot be blank") @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters") String phoneNumber,
                @NotBlank(message = "Entry date cannot be null") LocalDate entryDate,
                // retirementDate can be null
                LocalDate retirementDate,
                @Min(value = 0, message = "Base salary must be positive") double baseSalary,
                RollEmployee roll,
                @Email @NotBlank String email,
                @NotBlank @Size(min = 8, message = "Password must be at least 8 characters long") String password,
                @NotNull HashMap<Employee.Day, Employee.Hours> schedule) {
}

