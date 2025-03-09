package com.restaurant.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurant.model.document.Supplier;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {
  boolean existsById(String idSupplier);

  boolean existsByNameSupplier(String nameSupplier);

  @Query("{ 'nameSupplier' : ?0}")
  Optional<Supplier> searchSupplier(String nameSupplier);
}
