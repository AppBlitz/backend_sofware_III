package com.restaurant.controller.implementation.employee;

import com.restaurant.dto.employee.ManagerDTO;
import com.restaurant.dto.employee.PermissionsManagerDTO;
import com.restaurant.service.implementation.employees.ManagerServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Manager operations.
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerServices managerServices;

    /**
     * Constructor-based dependency injection for ManagerServices.
     *
     * @param managerServices Service layer for manager operations.
     */
    public ManagerController(ManagerServices managerServices) {
        this.managerServices = managerServices;
    }

    /**
     * Retrieves a list of all managers.
     *
     * @return A list of ManagerDTO objects.
     */
    @GetMapping
    public ResponseEntity<List<ManagerDTO>> getAllManagers() {
        List<ManagerDTO> managers = managerServices.getAllManagers();
        return ResponseEntity.ok(managers);
    }

    /**
     * Retrieves a specific manager by ID.
     *
     * @param id The unique identifier of the manager.
     * @return The ManagerDTO corresponding to the given ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ManagerDTO> getManagerById(@PathVariable String id) {
        try {
            ManagerDTO manager = managerServices.getManagerById(id);
            return ResponseEntity.ok(manager);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Creates a new manager record.
     *
     * @param managerDTO The ManagerDTO containing the manager's details.
     * @return The created ManagerDTO.
     */
    @PostMapping
    public ResponseEntity<ManagerDTO> createManager(@RequestBody ManagerDTO managerDTO) {
        ManagerDTO createdManager = managerServices.createManager(managerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdManager);
    }

    /**
     * Updates the details of an existing manager.
     *
     * @param managerDTO The ManagerDTO with updated information.
     * @return The updated ManagerDTO.
     */
    @PutMapping
    public ResponseEntity<ManagerDTO> updateManager(@RequestBody ManagerDTO managerDTO) {
        ManagerDTO updatedManager = managerServices.updateManager(managerDTO);
        return ResponseEntity.ok(updatedManager);
    }

    /**
     * Assigns permissions to a manager.
     *
     * @param permissionsDTO The PermissionsManagerDTO containing the permission details.
     * @return The ManagerDTO with updated permissions.
     */
    @PostMapping("/permissions")
    public ResponseEntity<ManagerDTO> addPermissions(@RequestBody PermissionsManagerDTO permissionsDTO) {
        ManagerDTO updatedManager = managerServices.addPermissions(permissionsDTO);
        return ResponseEntity.ok(updatedManager);
    }
}