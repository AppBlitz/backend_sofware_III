package com.restaurant.controller.Interface.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurant.dto.product.ProductActiveDto;
import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.model.document.Product;

import jakarta.validation.Valid;

public interface ProductControllerInterface {

  public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductDtoAdd productDtoAdd) throws Exception;

  public ResponseEntity<List<ProductActiveDto>> productsActive() throws Exception;
}
