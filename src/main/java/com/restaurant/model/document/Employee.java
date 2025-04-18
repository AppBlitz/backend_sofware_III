package com.restaurant.model.document;

import com.restaurant.model.Enum.employees.RollEmployee;
import com.restaurant.model.interfaces.IEmployee;
import com.restaurant.model.vo.RollForEmployee;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


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
 public enum EPS {
  SALUD_TOTAL, NUEVA_EPS, SURA, SANITAS
 }
 public enum ARL {
  SURA, POSITIVA, SEGUROS_BOLIVAR
 }
 public enum CCF {
  COMFENALCO_QUINDIO, COMFENALCO_ANTIOQUIA, COMFAMA, CAFAM
 }
 public enum RiskLevel {
  LEVEL_I, LEVEL_II, LEVEL_III, LEVEL_IV, LEVEL_V
 }
 public enum Cesantias {
  PORVENIR, COLFONDOS, FNA, PROTECCION
 }
 public enum Pension {
  COLPENSIONES, PORVENIR, PROTECCION
 }
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
 public enum Area {
  KITCHEN, WAREHOUSE, SALES
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

 @NotNull(message = "Retirement status cannot be null")
 private Boolean isRetired;

 @Min(value = 0, message = "Base salary must be positive")
 private double baseSalary;

 @NotNull(message = "Role cannot be null")
 private RollForEmployee roll;

 @NotNull(message = "User cannot be null")
 private User user;

 // Attributes from enums
 @NotNull(message = "EPS cannot be null")
 private EPS eps;

 @NotNull(message = "ARL cannot be null")
 private ARL arl;

 @NotNull(message = "CCF cannot be null")
 private CCF ccf;

 @NotNull(message = "Risk level cannot be null")
 private RiskLevel riskLevel;

 @NotNull(message = "Cesantias cannot be null")
 private Cesantias cesantias;

 @NotNull(message = "Pension cannot be null")
 private Pension pension;

 @NotNull(message = "Area cannot be null")
 private Area area;
}
