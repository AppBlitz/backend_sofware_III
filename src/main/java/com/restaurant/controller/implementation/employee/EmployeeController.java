package com.restaurant.controller.implementation.employee;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dto.employee.EmployeeDTO;
import com.restaurant.dto.employee.PermissionsEmployeeDTO;
import com.restaurant.dto.employee.RollDTO;
import com.restaurant.dto.employee.UserDTO;
import com.restaurant.service.implementation.employees.EmployeeServices;

/**
 * REST controller for handling Employee operations.
 */
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
     * Retrieves all employees currently active (not retired or retired after
     * today).
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
    @PostMapping("/add")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        if (employeeDTO.roll() == null) {

        }
        EmployeeDTO createdEmployee = employeeServices.create(employeeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

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
     * Adds permissions to a specific employee.
     *
     * @param permissionsEmployeeDTO The PermissionsEmployeeDTO containing
     *                               permissions details.
     * @return The EmployeeDTO with updated permissions.
     */
    @PostMapping("/permissions")
    public ResponseEntity<EmployeeDTO> addPermissions(@RequestBody PermissionsEmployeeDTO permissionsEmployeeDTO) {
        EmployeeDTO updatedEmployee = employeeServices.addPermissions(permissionsEmployeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/permissions")
    public ResponseEntity<EmployeeDTO> removePermissions(@RequestBody PermissionsEmployeeDTO permissionsEmployeeDTO) {
        EmployeeDTO updatedEmployee = employeeServices.removePermissions(permissionsEmployeeDTO);
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

    @PutMapping("/roll")
    public ResponseEntity<EmployeeDTO> updateRoll(@RequestBody RollDTO rollDTO) {
        return ResponseEntity.ok(employeeServices.updateRoll(rollDTO));

    }
}
