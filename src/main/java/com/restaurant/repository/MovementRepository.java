package com.restaurant.repository;

import com.restaurant.model.vo.MovementProduct;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovementRepository extends MongoRepository<MovementProduct, String> {

    @Query("{ 'timestamp': { $gte: ?0, $lt: ?1 } }")
    List<MovementProduct> findByTimestampBetween(LocalDateTime start, LocalDateTime end);

}
