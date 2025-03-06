package com.restaurant.controller.Inteface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurant.dto.product.ProductDtoAdd;

import jakarta.validation.*;

public interface ProductControllerInterface {

  public ResponseEntity<String> addProduct(@Valid @RequestBody ProductDtoAdd productDtoAdd);
}
