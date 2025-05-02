package com.restaurant.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurant.model.document.ShoppingCart;

@Repository
public interface ShoppingCartRespository extends MongoRepository<ShoppingCart, String> {

  @Query("{'id' : ?0}")
  Optional<ShoppingCart> findById(String id);

}
