package com.restaurant.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurant.model.Enum.CategoriItem;
import com.restaurant.model.Enum.cart.StateCart;
import com.restaurant.model.document.ShoppingCart;

@Repository
public interface ShoppingCartRespository extends MongoRepository<ShoppingCart, String> {

  @Query("{'id' : ?0}")
  Optional<ShoppingCart> findById(String id);

  @Query(" { 'categoriItem' : ?0 }")
  List<ShoppingCart> findByMenuIteCategoriItem(CategoriItem categoriItem);

  @Query(" { 'dateCreation' :?0 }")
  List<ShoppingCart> findByDateCreation(LocalDate dataCreation);

  @Query("{ 'stateCart'  : ?0}")
  List<ShoppingCart> findByStateCart(StateCart stateCart);
}
