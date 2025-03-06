package com.restaurant.controller.implementation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.controller.Inteface.ProductControllerInterface;
import com.restaurant.dto.product.ProductDtoAdd;

import jakarta.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController implements ProductControllerInterface {

  @Override
  @RequestMapping(value = "", method = RequestMethod.POST)
  public ResponseEntity<String> addProduct(@Valid ProductDtoAdd productDtoAdd) {
    return ResponseEntity.status(200).body("product successfully added");

  }

}
