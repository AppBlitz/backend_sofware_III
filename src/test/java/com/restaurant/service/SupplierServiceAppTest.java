package com.restaurant.service;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.dto.supplier.SupplierDtoAdd;
import com.restaurant.dto.supplier.SupplierDtoEdit;
import com.restaurant.model.Enum.Estate;
import com.restaurant.service.implementation.inventory.SupplierServices;

@SpringBootTest
public class SupplierServiceAppTest {

  @Autowired
  SupplierServices supplierServices;

  @Test
  public void updatedDataSupplier() {
    List<String> listProducts = new ArrayList<>();
    listProducts.add("Frijoles");
    SupplierDtoEdit supplierUpdated = new SupplierDtoEdit("67cdc25034dbb71530852113", "Jahn", "New York",
        LocalDate.now(), listProducts, Estate.ACTIVE);
    assertNotEquals(supplierServices.getSupplier("67cdc25034dbb71530852113"),
        supplierServices.editSupplier(supplierUpdated));
  }

  @Test
  public void createSUpplier() {
    List<String> listProdcuts = new ArrayList<>();
    listProdcuts.add("Frijoles");
    SupplierDtoAdd supplier = new SupplierDtoAdd("Isabela", "Tokyo", LocalDate.now(), listProdcuts, Estate.ACTIVE);
    assertNotNull(supplierServices.addSupplier(supplier));
  }

  @Test
  public void deleteSupplier() {
    assertNotEquals(supplierServices.getSupplier("67cdc25034dbb71530852113"),
        supplierServices.deleteSupplier("67cdc25034dbb71530852113"));
  }

  @Test
  public void verificationProduct() {
    assertThrows(IllegalArgumentException.class,
        () -> supplierServices.verification_product_supplier("", new ArrayList<>()));
  }

}
