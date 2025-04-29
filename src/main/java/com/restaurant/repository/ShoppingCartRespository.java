package com.restaurant.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.model.document.ShoppingCart;

@Repository
public interface ShoppingCartRespository extends MongoRepository<ShoppingCart, String> {

}
