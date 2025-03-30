package com.restaurant.controller.Interface;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.restaurant.dto.product.ListProducts;
import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.model.document.Product;

import jakarta.validation.*;

public interface ProductControllerInterface {

  /**
   * @param productDtoAdd
   * @return
   * @throws Exception
   */
  public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductDtoAdd productDtoAdd) throws Exception;

  /**
   * @return
   */
  public ArrayList<ListProducts> getAllProducts();
}
