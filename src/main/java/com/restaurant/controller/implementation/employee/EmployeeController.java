package com.restaurant.controller.implementation.employee;

import com.restaurant.dto.employee.*;
import com.restaurant.exceptions.employees.DuplicateEmployeeException;
import com.restaurant.exceptions.employees.NotCorrectPasswordException;
import com.restaurant.exceptions.employees.NotFoundEmployeeException;
import com.restaurant.model.vo.RollForEmployee;
import com.restaurant.service.implementation.employees.EmployeeServices;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * REST controller for handling Employee operations.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServices employeeServices;
    /**
     * Constructor-based dependency injection for EmployeeServices.
     *
     * @param employeeServices Service layer for employee operations.
     */
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    /**
     * Retrieves all employees currently active (not retired or retired after today).
     *
     * @return A list of EmployeeDTO objects.
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeServices.getAll();
        return ResponseEntity.ok(employees);
    }

    /**
     * Retrieves the details of a specific employee by ID.
     *
     * @param id The unique identifier of the employee.
     * @return The EmployeeDTO corresponding to the given ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable String id) {
        try {
            EmployeeDTO employee = employeeServices.get(id);
            return ResponseEntity.ok(employee);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    /**
     * Retrieves a list of active employees up until a specific date.
     *
     * @param date The date up to which active employees will be fetched.
     * @return A list of EmployeeDTO objects.
     */
    @GetMapping("/active-until")
    public ResponseEntity<List<EmployeeDTO>> getActiveEmployeesUntil(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<EmployeeDTO> employees = employeeServices.getActiveEmployeesUntilDate(date);
        return ResponseEntity.ok(employees);
    }

    /**
     * Creates a new employee record.
     *
     * @param employeeDTO The EmployeeDTO containing the employee's details.
     * @return The created EmployeeDTO.
     */
    @PostMapping
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        try {
            EmployeeDTO createdEmployee = employeeServices.create(employeeDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
        } catch (DuplicateEmployeeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("El empleado no pudo ser creado", e.getMessage()));
        }
    }
    public record ErrorResponse(String error, String details) {}

    /**
     * Updates the details of an existing employee.
     *
     * @param employeeDTO The EmployeeDTO with updated information.
     * @return The updated EmployeeDTO.
     */
    @PutMapping
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeServices.update(employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    /**
     * Updates the user information (e.g., password) for an employee.
     *
     * @param userDTO The UserDTO containing the updated user information.
     * @return The updated UserDTO.
     */
    @PutMapping("/user")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        UserDTO updatedUser = employeeServices.UpdateUser(userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/user/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        try {
            return ResponseEntity.ok(employeeServices.login(loginDTO));
        } catch (NotFoundEmployeeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("El empleado no existe", e.getMessage()));
        } catch (NotCorrectPasswordException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("La contraseña es incorrecta", e.getMessage()));
        }
    }
}
