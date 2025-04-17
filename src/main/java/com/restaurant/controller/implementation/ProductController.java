package com.restaurant.controller.implementation;

import java.util.*;

import com.restaurant.dto.product.MovementDto;
import com.restaurant.model.vo.MovementProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.restaurant.controller.Interface.ProductControllerInterface;
import com.restaurant.dto.product.ListProducts;
import com.restaurant.dto.product.ProductDtoAdd;
import com.restaurant.model.document.Product;
import com.restaurant.service.implementation.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "*")
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

//  @Override
//  @RequestMapping(value = "/all", method = RequestMethod.GET)
//  public ArrayList<ListProducts> getAllProducts() {
//    return productService.getAllProducts();
//  }

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
  public ResponseEntity<MovementProduct> movementProduct(@PathVariable String id, @RequestBody @Valid MovementDto movementdto) throws Exception {
    MovementProduct products = productService.updateAmount(id, movementdto);
    return ResponseEntity.status(200).body(products);
  }

}
