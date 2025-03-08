package com.restaurant.repository;

import java.util.*;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;

import com.restaurant.model.document.Product;

@Repository
public interface ProductoRepository extends MongoRepository<Product, String> {

  Optional<Product> findByCantidadBefore(int cantidadBefore);
  // @Query("{ 'cantidad' : { $lt: ?0 } }")
  // List<Product> findLowStockProducts(int stockThreshold);

  Optional<Product> findByNameProduct(String nombreProducto);

  @Query("{ 'cantidad' : { $lt: ?0 } }")
  List<Product> findLowStockProducts(int stockThreshold);
}
