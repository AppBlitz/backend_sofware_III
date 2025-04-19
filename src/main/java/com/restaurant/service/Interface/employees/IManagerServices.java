package com.restaurant.service.Interface.employees;

import com.restaurant.dto.employee.ManagerDTO;
import com.restaurant.dto.employee.EmployeeDTO;
import com.restaurant.dto.employee.PermissionsEmployeeDTO;
import com.restaurant.dto.employee.PermissionsManagerDTO;

import java.util.List;

/**
 * Interface defining the contract for manager-related services in the restaurant system.
 * Provides methods for CRUD operations and management functionalities.
 */
public interface IManagerServices {

    /**
     * Retrieves a list of all managers.
     * @return A list of ManagerDTO objects.
     */
    List<ManagerDTO> getAllManagers();

    /**
     * Retrieves a specific manager by their ID.
     * @param id The unique identifier of the manager.
     * @return The corresponding ManagerDTO.
     */
    ManagerDTO getManagerById(String id);

    /**
     * Creates a new manager record.
     * @param managerDTO The ManagerDTO containing the details.
     * @return The created ManagerDTO.
     */
    ManagerDTO createManager(ManagerDTO managerDTO);

    /**
     * Updates the details of an existing manager.
     * @param managerDTO The ManagerDTO with updated information.
     * @return The updated ManagerDTO.
     */
    ManagerDTO updateManager(ManagerDTO managerDTO);

    /**
     * Assigns permissions to a manager.
     * @param permissionsDTO The DTO containing the permission details.
     * @return The updated PermissionsEmployeeDTO.
     */
    ManagerDTO addPermissions(PermissionsManagerDTO permissionsDTO);

    /**
     * @param employeeId
     * @return boolean
     */
    boolean isEmployeeAssociatedWithManager(String employeeId);

    ManagerDTO removePermissions(PermissionsManagerDTO permissionsManagerDTO);

    /**
     * Updates the password of a user associated with an employee.
     * @param userDTO The UserDTO containing the updated password.
     * @return The updated UserDTO with the new password.
     */
}
