package com.restaurant.controller.implementation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.controller.Interface.ProductControllerInterface;
import com.restaurant.dto.employee.EmployeeDTO;
import com.restaurant.dto.product.MovementDto;
import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.dto.product.ProductUpdateDto;
import com.restaurant.exceptions.product.ExceptionUpdateProduct;
import com.restaurant.model.document.Employee;
import com.restaurant.model.document.Product;
import com.restaurant.model.vo.MovementProduct;
import com.restaurant.service.implementation.employees.EmployeeServices;
import com.restaurant.service.implementation.inventory.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController implements ProductControllerInterface {

  @Autowired(required = true)
  public ProductService productService;

  @Autowired
  public EmployeeServices employeeServices;

  @Override
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductDtoAdd productDtoAdd) throws Exception {
    Product product = productService.addProduct(productDtoAdd);
    return ResponseEntity.status(200).body(product);
  }

  @RequestMapping(value = "/update", method = RequestMethod.PUT)
  public ResponseEntity<Product> editProduct(@RequestBody @Valid ProductUpdateDto productUpdateDto) throws Exception {
    Product product = productService.updateProduct(productUpdateDto);
    return ResponseEntity.status(200).body(product);
  }

  @RequestMapping(value = "/available", method = RequestMethod.GET)
  public ResponseEntity<List<Product>> getAvailableProducts() throws Exception {
    List<Product> products = productService.getAvailableProducts();
    if (products.isEmpty()) {
      return ResponseEntity.status(204).build(); // No Content
    }
    return ResponseEntity.status(200).body(products);
  }

  @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
  public ResponseEntity<Product> getProduct(@PathVariable String id) throws Exception {
    Product products = productService.getProduct(id);
    return ResponseEntity.status(200).body(products);
  }

  @RequestMapping(value = "/allProducts", method = RequestMethod.GET)
  public ResponseEntity<List<Product>> getListProducts() {
    List<Product> p = productService.getListProducts();
    return ResponseEntity.status(200).body(p);
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Product> DeleteProduct(@PathVariable String id) throws Exception {
    Product products = productService.deleteProduct(id);
    return ResponseEntity.status(200).body(products);
  }

  @RequestMapping(value = "/movement/{id}", method = RequestMethod.POST)
  public ResponseEntity<MovementProduct> movementProduct(@PathVariable String id,
      @RequestBody @Valid MovementDto movementdto) throws ExceptionUpdateProduct {
    MovementProduct products = productService.updateAmount(id, movementdto);
    return ResponseEntity.status(200).body(products);
  }

  @RequestMapping(value = "/movementByDate", method = RequestMethod.GET)
  public ResponseEntity<List<MovementProduct>> getByDate(
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
    List<MovementProduct> results = productService.consult_movementsByDate(date);
    return ResponseEntity.ok(results);
  }

  @RequestMapping(value = "/movementByRangeHour", method = RequestMethod.GET)
  public ResponseEntity<List<MovementProduct>> getByHour(
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
      @RequestParam int startHour,
      @RequestParam int endHour) {
    List<MovementProduct> results = productService.consult_movementsByHour(date, startHour, endHour);
    return ResponseEntity.ok(results);
  }

  @RequestMapping(value = "/historyEmployee", method = RequestMethod.GET)
  public ResponseEntity<List<MovementProduct>> getHistoryByEmployeeAndDate(
      @RequestParam String employeeId,
      @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

    DayOfWeek dayOfWeek = date.getDayOfWeek(); // Ej: MONDAY
    Employee.Day diaSemana = Employee.Day.valueOf(dayOfWeek.name()); // Convertir a tu enum

    EmployeeDTO empleado = employeeServices.get(employeeId);
    Map<Employee.Day, Employee.Hours> horarios = empleado.schedule();

    if (!horarios.containsKey(diaSemana)) {
      return ResponseEntity.ok(Collections.emptyList()); // No trabajó ese día
    }

    Employee.Hours horario = horarios.get(diaSemana);

    List<MovementProduct> actividades = productService.consult_movementsByHour(
        date, horario.getHourStart(), horario.getHourEnd());

    return ResponseEntity.ok(actividades);
  }

}
