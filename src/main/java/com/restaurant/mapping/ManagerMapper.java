package com.restaurant.mapping;

import com.restaurant.dto.employee.ManagerDTO;
import com.restaurant.dto.employee.PermissionsManagerDTO;
import com.restaurant.model.document.Manager;
import com.restaurant.model.vo.Permissions;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ManagerMapper {
    ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);

    ManagerDTO managerToManagerDTO(Manager manager);

    Manager managerDTOToManager(ManagerDTO managerDTO);

    @Mapping(target = "managerID", ignore = true)
    PermissionsManagerDTO permissionsToPermissionsManagerDTO(Permissions permission);

    Permissions permissionsManagerDTOToPermissions(PermissionsManagerDTO permissionsManagerDTO);
}
