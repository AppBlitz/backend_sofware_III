package com.restaurant.repository;

import java.time.LocalDate;
import java.util.*;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import com.restaurant.model.Enum.Estate;
import com.restaurant.model.document.Product;

import lombok.NonNull;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

  @Query("{ 'stock' : { $gt: ?0 } }")
  List<Product> findByStockGreaterThan(int stock);

  Optional<Product> findByNameProduct(String productName);

  @Query("{ 'stock' : { $lt: ?0 } }")
  List<Product> findLowStockProducts(int stockThreshold);

  @Query("{ 'dateExpiration.0': { $gte: ?0, $lte: ?1 } }")
  List<Product> findProductsExpiring(LocalDate startDate, LocalDate endDate);

  @Query("{ 'nameProduct' : ?0 }")
  boolean existsByNameProduct(String nameProduct);

  @Query("{ 'state' : ?0}")
  List<Product> findByState(@NonNull Estate state);

  @Query("{ '_id' : ?0 }")
  boolean existsById(String id);

}
