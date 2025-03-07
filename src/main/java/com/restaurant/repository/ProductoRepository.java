package com.restaurant.repository;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.document.Product;

@Repository
public interface ProductoRepository extends MongoRepository<Product, String> {

  Optional<Product> findByNameProduct(String nombreProducto);

  public default boolean validarExistsSupplier(ArrayList<String> suppliers, String nameSupplier) {
    for (String supplier : suppliers) {
      if (supplier.equals(nameSupplier)) {
        return true;
      }
    }
    return false;
  }
}
