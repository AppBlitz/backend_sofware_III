package com.restaurant.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaurant.service.implementation.ProductService;

@SpringBootTest
public class ProductServiceAppTest {

  @Value("${my.test.userOne}")
  private String id;

  @Autowired
  ProductService productService;

  @Test
  public void createProductTest() {

  }

}
