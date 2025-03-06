package com.restaurant.controller.Inteface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.model.document.Product;

import jakarta.validation.*;

public interface ProductControllerInterface {

  public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductDtoAdd productDtoAdd) throws Exception;
}
