package com.restaurant.service.implementation.employees;

import com.restaurant.dto.employee.EmployeeDTO;
import com.restaurant.dto.employee.PermissionsEmployeeDTO;
import com.restaurant.dto.employee.UserDTO;
import com.restaurant.mapping.EmployeeMapper;
import com.restaurant.model.document.Employee;
import com.restaurant.model.vo.Permissions;
import com.restaurant.repository.EmployeeRepository;
import com.restaurant.service.Interface.employees.IEmployeeServices;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServices implements IEmployeeServices {
    private final EmployeeRepository employeeRepository;
    private final ManagerServices managerServices;

    public EmployeeServices(EmployeeRepository employeeRepository, ManagerServices managerServices) {
        this.employeeRepository = employeeRepository;
        this.managerServices = managerServices;
    }



    private final EmployeeMapper mapper = EmployeeMapper.INSTANCE;

    /**
     * Fetches all employees in the system.
     *
     * @return A list of EmployeeDTO objects representing all employees.
     */
    @Override
    public List<EmployeeDTO> getAll() {
        return convertList(employeeRepository.getAllByRetirementDateIsNullOrRetirementDateAfter(LocalDate.now()));
    }

    private List<EmployeeDTO> convertList(List<Employee> employees) {
        return employees.stream()
                .map(mapper::employeeToEmployeeDTO)
                .collect(Collectors.toCollection(ArrayList::new));
    }


    /**
     * Fetches the details of a specific employee by their ID.
     *
     * @param id The unique identifier of the employee.
     * @return The EmployeeDTO corresponding to the given ID.
     */
    @Override
    public EmployeeDTO get(String id) {
        return mapper.employeeToEmployeeDTO(employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Manager not found")));
    }

    /**
     * Creates a new employee record in the system.
     *
     * @param employeeDTO The EmployeeDTO containing the details of the new employee.
     * @return The created EmployeeDTO.
     */
    @Override
    public EmployeeDTO create(EmployeeDTO employeeDTO) {
        return mapper.employeeToEmployeeDTO(employeeRepository.save(mapper.employeeDTOToEmployee(employeeDTO)));
    }

    /**
     * Updates the details of an existing employee.
     *
     * @param employeeDTO The EmployeeDTO containing the updated employee information.
     * @return The updated EmployeeDTO.
     */
    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        return mapper.employeeToEmployeeDTO(employeeRepository.save(mapper.employeeDTOToEmployee(employeeDTO)));
    }


    /**
     * Adds permissions to a specific employee.
     *
     * @param permissionsEmployeeDTO The PermissionsEmployeeDTO containing the permission details.
     * @return The updated PermissionsEmployeeDTO with the applied permissions.
     */
    @Override
    public EmployeeDTO addPermissions(PermissionsEmployeeDTO permissionsEmployeeDTO) {
        Employee employee = employeeRepository.getById(permissionsEmployeeDTO.employeeID());
        Permissions permissions = mapper.permissionsEmployeeDTOToPermissions(permissionsEmployeeDTO);
        for(Permissions permissions1 : employee.getRoll().getPermissions()){
            if(permissions1.getObjeto().equals(permissionsEmployeeDTO.objeto())){
                permissions.getPermissions().addAll(permissions1.getPermissions());
                int index = employee.getRoll().getPermissions().indexOf(permissions1);
                employee.getRoll().getPermissions().set(index,permissions);
                return mapper.employeeToEmployeeDTO(employeeRepository.save(employee));
            }
        }
        employee.getRoll().getPermissions().add(permissions);
        return mapper.employeeToEmployeeDTO(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO removePermissions(PermissionsEmployeeDTO permissionsEmployeeDTO) {
        Employee employee = employeeRepository.getById(permissionsEmployeeDTO.employeeID());
        Permissions permissions = mapper.permissionsEmployeeDTOToPermissions(permissionsEmployeeDTO);
        for(Permissions permissions1 : employee.getRoll().getPermissions()){
            if(permissions1.getObjeto().equals(permissionsEmployeeDTO.objeto())){
                permissions1.getPermissions().removeAll(permissions.getPermissions());
                int index = employee.getRoll().getPermissions().indexOf(permissions1);
                employee.getRoll().getPermissions().set(index,permissions1);
                return mapper.employeeToEmployeeDTO(employeeRepository.save(employee));
            }
        }
        employee.getRoll().getPermissions().add(permissions);
        return mapper.employeeToEmployeeDTO(employeeRepository.save(employee));
    }
    /**
     * Updates the password of a user associated with an employee.
     *
     * @param userDTO The UserDTO containing the updated password.
     * @return The updated UserDTO with the new password.
     */
    @Override
    public UserDTO UpdateUser(UserDTO userDTO) {
        Employee employee = employeeRepository.getById(userDTO.employeeId());
        Employee.User user = mapper.userDTOToUser(userDTO);
        employeeRepository.save(employee);
        return userDTO;
    }

    /**
     * Retrieves a list of active employees whose status is valid until a specific date.
     *
     * @param date The cut-off date for retrieving active employees.
     * @return A list of EmployeeDTOs representing active employees until the given date.
     */
    @Override
    public List<EmployeeDTO> getActiveEmployeesUntilDate(LocalDate date) {
        return convertList(employeeRepository.getAllByRetirementDateIsNullOrRetirementDateAfter(date));
    }
}
