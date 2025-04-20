package com.restaurant.dto.employee;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.restaurant.model.document.Employee;
import com.restaurant.model.vo.RollForEmployee;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

public record EmployeeDTO(

                @Null @Id String id,
                @NotBlank(message = "Employee name cannot be blank") String nameEmployee,
                @NotBlank(message = "Address cannot be blank") String address,
                @NotBlank(message = "City cannot be blank") String city,
                @NotBlank(message = "Phone number cannot be blank") @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters") String phoneNumber,
                @NotBlank(message = "Entry date cannot be null") LocalDate entryDate,
                // retirementDate can be null
                LocalDate retirementDate,
                @NotNull(message = "Retirement status cannot be null") Boolean isRetired,
                @Min(value = 0, message = "Base salary must be positive") double baseSalary,
                RollForEmployee roll,
                @Email @NotBlank String email,
                @NotBlank @Size(min = 8, message = "Password must be at least 8 characters long") String password,
                // Attributes from enums
                @NotNull(message = "EPS cannot be null") Employee.EPS eps,
                @NotNull(message = "ARL cannot be null") Employee.ARL arl,
                @NotNull(message = "CCF cannot be null") Employee.CCF ccf,
                @NotNull(message = "Risk level cannot be null") Employee.RiskLevel riskLevel,
                @NotNull(message = "Cesantias cannot be null") Employee.Cesantias cesantias,
                @NotNull(message = "Pension cannot be null") Employee.Pension pension,
                @NotNull(message = "Area cannot be null") Employee.Area area) {
}
