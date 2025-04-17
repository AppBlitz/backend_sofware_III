package com.restaurant.repository;

import com.restaurant.model.vo.MovementProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends MongoRepository<MovementProduct, String> {
}
