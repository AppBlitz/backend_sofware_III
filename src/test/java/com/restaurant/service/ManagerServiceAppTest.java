package com.restaurant.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.dto.employee.ManagerDTO;
import com.restaurant.service.implementation.employees.ManagerServices;

@SpringBootTest
public class ManagerServiceAppTest {

  @Autowired
  ManagerServices managerServices;

  @ParameterizedTest
  @ValueSource(strings = { "", "12345", "123465" })
  public void searchManager(String id) {
    assertNotNull(managerServices.getManagerById(id));
  }

  @Test
  public void listManager() {
    List<ManagerDTO> managers = managerServices.getAllManagers();
    assertTrue(managers.size() >= 0);
  }

  @Test
  public void addPermissions() {

  }

}
