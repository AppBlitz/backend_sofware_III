package com.restaurant.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.document.Product;

@Repository
public interface ProductoRepository extends MongoRepository<Product, String> {

  Optional<Product> findByNombreProducto(String nombreProducto);
}
