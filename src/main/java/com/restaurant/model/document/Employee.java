package com.restaurant.model.document;

import com.restaurant.model.Enum.employees.RollEmployee;
import com.restaurant.model.interfaces.IEmployee;
import com.restaurant.model.vo.RollForEmployee;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashMap;


@AllArgsConstructor
@Document(collection = "employee")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
/*
 * The Employee class represents an employee in the restaurant.
 * It includes information about the employee's ID, DNI, name, schedule, charge, base salary, email, password, permissions, and role.
 */
public class Employee implements IEmployee {

 @Data
 @AllArgsConstructor
 @NoArgsConstructor
 @ToString
 public static class User {
  @Email
  @NotBlank
  private String email;

  @NotBlank
  @Size(min = 8, message = "Password must be at least 8 characters long")
  private String password;
 }

 @Id
 private String id;

 @NotBlank(message = "Employee name cannot be blank")
 private String nameEmployee;

 @NotBlank(message = "Address cannot be blank")
 private String address;

 @NotBlank(message = "City cannot be blank")
 private String city;

 @NotBlank(message = "Phone number cannot be blank")
 @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
 private String phoneNumber;

 @NotBlank(message = "Entry date cannot be null")
 private LocalDate entryDate;

 //retirementDate can be null
 private LocalDate retirementDate;

 @Min(value = 0, message = "Base salary must be positive")
 private double baseSalary;

 @NotNull(message = "Role cannot be null")
 private RollEmployee roll;

 @NotNull(message = "User cannot be null")
 private User user;

 @NotNull
 private HashMap<Day,Hours> schedule;

 @Data
 @ToString
 @Builder
 @AllArgsConstructor
 @NoArgsConstructor
 public static class Hours{
  @NotNull
  Integer HourStart;
  @NotNull
  Integer HourEnd;
 }
 public enum Day {
  LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
 }
}