package com.restaurant.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.dto.employee.EmployeeDTO;
import com.restaurant.dto.employee.PermissionsEmployeeDTO;
import com.restaurant.dto.employee.UserDTO;
import com.restaurant.model.Enum.Objeto;
import com.restaurant.model.Enum.employees.PermisionsCRUD;
import com.restaurant.model.Enum.employees.RollEmployee;
import com.restaurant.model.document.Employee.ARL;
import com.restaurant.model.document.Employee.Area;
import com.restaurant.model.document.Employee.CCF;
import com.restaurant.model.document.Employee.Cesantias;
import com.restaurant.model.document.Employee.EPS;
import com.restaurant.model.document.Employee.Pension;
import com.restaurant.model.document.Employee.RiskLevel;
import com.restaurant.model.vo.Permissions;
import com.restaurant.model.vo.RollForEmployee;
import com.restaurant.service.implementation.employees.EmployeeServices;

@SpringBootTest
public class EmployeeServiceAppTest {

    @Autowired
    EmployeeServices employeeServices;

    /*
     * Test to see if it brings the full list of users in case there are any,
     */
    @Test
    public void listEmployees() {
        List<EmployeeDTO> employee = employeeServices.getAll();
        assertNotNull(employee);
    }

    @Test
    public void createEmployee() {
        HashSet<PermisionsCRUD> permisos = new HashSet<>();
        permisos.add(PermisionsCRUD.CONSULTAR);

        Permissions permision = Permissions.builder()
                .permissions(permisos)
                .objeto(Objeto.OB_EMPLOYEE)
                .build();

        ArrayList<Permissions> listPermisions = new ArrayList<>();
        listPermisions.add(permision);
        RollForEmployee rol = new RollForEmployee(RollEmployee.WarehouseEmployee,
                listPermisions);
        EmployeeDTO employee = new EmployeeDTO(
                "Luis",
                "Carrera 13-45",
                "Tapéi",
                "+8861345678901",
                LocalDate.now(),
                null,
                false,
                1200000.0,
                rol,
                "Luis@gmail.com",
                "213465gtfr",
                EPS.NUEVA_EPS,
                ARL.POSITIVA,
                CCF.CAFAM,
                RiskLevel.LEVEL_III,
                Cesantias.COLFONDOS,
                Pension.COLPENSIONES,
                Area.KITCHEN);

        assertNotNull(employeeServices.create(employee));
    }

    @ParameterizedTest
    @ValueSource(strings = { "680290f571ae414c518bf1ca", "1234", "6804517345ac661cd01e849e" })
    public void searchEmployee(String id) {
        assertNotNull(employeeServices.get(id));
    }

    @Test
    public void addPermisions() {

        HashSet<PermisionsCRUD> permissionss = new HashSet<>();
        permissionss.add(PermisionsCRUD.ELIMINAR);
        PermissionsEmployeeDTO permissions = new PermissionsEmployeeDTO("6804517345ac661cd01e849e", permissionss,
                Objeto.OB_MENU);
        assertNotNull(employeeServices.addPermissions(permissions));
    }

    @Test
    void deletePermissions() {
        HashSet<PermisionsCRUD> permissionss = new HashSet<>();
        permissionss.add(PermisionsCRUD.ELIMINAR);
        PermissionsEmployeeDTO permissions = new PermissionsEmployeeDTO("6804517345ac661cd01e849e", permissionss,
                Objeto.OB_MENU);
        assertNotNull(employeeServices.removePermissions(permissions));
    }

    @Test
    public void updatedDataUser() {
        assertNotNull(
                employeeServices.UpdateUser(new UserDTO("6804517345ac661cd01e849e", "a@gmail.com", "123456hycd")));
    }

}
