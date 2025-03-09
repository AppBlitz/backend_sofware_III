package com.restaurant.repository;

import java.util.*;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import com.restaurant.model.document.Product;

@Repository
public interface ProductoRepository extends MongoRepository<Product, String> {

  Optional<Product> findByStockGreaterThan(int quantity);

  Optional<Product> findByNameProduct(String productName);

  @Query("{ 'quantity' : { $lt: ?0 } }")
  List<Product> findLowStockProducts(int stockThreshold);

  boolean existsByNameProduct(String nameProduct);

}
