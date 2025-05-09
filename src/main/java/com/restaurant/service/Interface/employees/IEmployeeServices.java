// Package declaration for employee services interface
package com.restaurant.service.Interface.employees;

// Import statements for DTOs and other required classes
import com.restaurant.dto.employee.EmployeeDTO; // Data Transfer Object for Employee
import com.restaurant.dto.employee.LoginDTO;
import com.restaurant.dto.employee.PermissionsEmployeeDTO; // DTO for Employee Permissions
import com.restaurant.dto.employee.UserDTO; // DTO for User details
import com.restaurant.exceptions.employees.DuplicateEmployeeException;
import com.restaurant.exceptions.employees.NotCorrectPasswordException;
import com.restaurant.exceptions.employees.NotFoundEmployeeException;
import com.restaurant.model.document.Employee; // Employee document model

import java.time.LocalDate; // For handling dates
import java.util.ArrayList; // Utility for list initialization
import java.util.List; // List interface for collections

/**
 * Interface defining the contract for employee-related services in the application.
 * Provides methods for CRUD operations and additional functionalities like updating user details,
 * managing permissions, and retrieving active employees within a specified time frame.
 */
public interface IEmployeeServices {

    /**
     * Fetches all employees in the system.
     * @return A list of EmployeeDTO objects representing all employees.
     */
    List<EmployeeDTO> getAll();

    /**
     * Fetches the details of a specific employee by their ID.
     * @param id The unique identifier of the employee.
     * @return The EmployeeDTO corresponding to the given ID.
     */
    EmployeeDTO get(String id);

    /**
     * Creates a new employee record in the system.
     * @param employeeDTO The EmployeeDTO containing the details of the new employee.
     * @return The created EmployeeDTO.
     */
    EmployeeDTO create(EmployeeDTO employeeDTO) throws DuplicateEmployeeException;

    /**
     * Updates the details of an existing employee.
     * @param employeeDTO The EmployeeDTO containing the updated employee information.
     * @return The updated EmployeeDTO.
     */
    EmployeeDTO update(EmployeeDTO employeeDTO);

    /**
     * Updates the password of a user associated with an employee.
     * @param userDTO The UserDTO containing the updated password.
     * @return The updated UserDTO with the new password.
     */
    UserDTO UpdateUser(UserDTO userDTO);

    /**
     * Retrieves a list of active employees whose status is valid until a specific date.
     * @param date The cut-off date for retrieving active employees.
     * @return A list of EmployeeDTOs representing active employees until the given date.
     */
    List<EmployeeDTO> getActiveEmployeesUntilDate(LocalDate date);

    EmployeeDTO login(LoginDTO loginDTO) throws NotFoundEmployeeException, NotCorrectPasswordException;
}