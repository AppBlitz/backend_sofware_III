package com.restaurant.controller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.controller.Inteface.ProductControllerInterface;
import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.model.document.Product;
import com.restaurant.service.implementation.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("product")
public class ProductController implements ProductControllerInterface {

  @Autowired(required = true)
  public ProductService productService;

  @Override
  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public ResponseEntity<Product> addProduct(@Valid ProductDtoAdd productDtoAdd) throws Exception {
    Product product = productService.addProduct(productDtoAdd);
    return ResponseEntity.status(200).body(product);
  }

}
