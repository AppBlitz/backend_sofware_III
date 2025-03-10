package com.restaurant.controller.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.controller.Interface.ProductControllerInterface;
import com.restaurant.dto.product.ListProducts;
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
  public ResponseEntity<Product> addProduct(@RequestBody @Valid ProductDtoAdd productDtoAdd) throws Exception {
    Product product = productService.addProduct(productDtoAdd);
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

  @Override
  @RequestMapping(value = "/all", method = RequestMethod.GET)
  public ArrayList<ListProducts> getAllProducts() {
    return productService.getAllProducts();
  }

}
