package com.restaurant.mapping;

import com.restaurant.dto.employee.EmployeeDTO;
import com.restaurant.dto.employee.PermissionsEmployeeDTO;
import com.restaurant.dto.employee.UserDTO;
import com.restaurant.model.document.Employee;
import com.restaurant.model.vo.Permissions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE =Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "user.email",target = "email")
    @Mapping(source = "user.password",target = "password")
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    @Mapping(source = "email",target = "user.email")
    @Mapping(source = "password",target = "user.password")
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);

    @Mapping(target = "employeeId", ignore = true)
    UserDTO userToUserDTO(Employee.User user);

    Employee.User userDTOToUser(UserDTO userDTO);

    @Mapping(target = "employeeID", ignore = true)
    PermissionsEmployeeDTO permissionsToPermissionsEmployeeDTO(Permissions permission);

    Permissions permissionsEmployeeDTOToPermissions(PermissionsEmployeeDTO permissionsEmployeeDTO);
}
