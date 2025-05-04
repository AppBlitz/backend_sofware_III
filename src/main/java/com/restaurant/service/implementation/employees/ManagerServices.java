package com.restaurant.service.implementation.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.dto.employee.ManagerDTO;
import com.restaurant.dto.employee.PermissionsManagerDTO;
import com.restaurant.mapping.ManagerMapper;
import com.restaurant.model.document.Manager;
import com.restaurant.model.vo.Permissions;
import com.restaurant.repository.ManagerRepository;
import com.restaurant.service.Interface.employees.IManagerServices;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Service
public class ManagerServices implements IManagerServices {

    @Autowired
    private ManagerRepository managerRepository;

    /**
     * Retrieves a list of all managers.
     *
     * @return A list of ManagerDTO objects.
     */
    @Override
    public List<ManagerDTO> getAllManagers() {
        List<Manager> managers = managerRepository.findAll();
        return managers.stream()
                .map(ManagerMapper.INSTANCE::managerToManagerDTO)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a specific manager by their ID.
     *
     * @param id The unique identifier of the manager.
     * @return The corresponding ManagerDTO.
     */
    @Override
    public ManagerDTO getManagerById(String id) {
        Manager manager = managerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        return ManagerMapper.INSTANCE.managerToManagerDTO(manager);
    }

    @Override
    public boolean isEmployeeAssociatedWithManager(String employeeId) {
        return managerRepository.findById(employeeId).isPresent();
    }

    /**
     * @param permissionsManagerDTO
     * @return
     */
    @Override
    public ManagerDTO removePermissions(PermissionsManagerDTO permissionsManagerDTO) {
        return null;
    }

    /**
     * Creates a new manager record.
     *
     * @param managerDTO The ManagerDTO containing the details.
     * @return The created ManagerDTO.
     */
    @Override
    public ManagerDTO createManager(ManagerDTO managerDTO) {
        Manager manager = ManagerMapper.INSTANCE.managerDTOToManager(managerDTO);
        Manager savedManager = managerRepository.save(manager);
        return ManagerMapper.INSTANCE.managerToManagerDTO(savedManager);
    }

    /**
     * Updates the details of an existing manager.
     *
     * @param managerDTO The ManagerDTO with updated information.
     * @return The updated ManagerDTO.
     */
    @Override
    public ManagerDTO updateManager(ManagerDTO managerDTO) {
        Manager manager = ManagerMapper.INSTANCE.managerDTOToManager(managerDTO);
        Manager updatedManager = managerRepository.save(manager);
        return ManagerMapper.INSTANCE.managerToManagerDTO(updatedManager);
    }

    /**
     * Assigns permissions to a manager.
     *
     * @param permissionsDTO The DTO containing the permission details.
     * @return The updated ManagerDTO.
     */
    @Override
    public ManagerDTO addPermissions(PermissionsManagerDTO permissionsDTO) {
        Manager manager = managerRepository.findById(permissionsDTO.managerID())
                .orElseThrow(() -> new RuntimeException("Manager not found"));
        @NotNull(message = "Permissions cannot be null")
        @Size(min = 1, message = "There must be at least one permission")
        ArrayList<Permissions> permissions = manager.getRollManager().getPermissions();
        permissions.add(ManagerMapper.INSTANCE.permissionsManagerDTOToPermissions(permissionsDTO));
        return ManagerMapper.INSTANCE.managerToManagerDTO(managerRepository.save(manager));
    }
}
