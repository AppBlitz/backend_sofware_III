package com.restaurant.repository;

import com.restaurant.model.vo.HistoryRecipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HistoryRecipeRepository extends MongoRepository<HistoryRecipe, String> {
    @Query("{ 'timestamp': { $gte: ?0, $lt: ?1 } }")
    List<HistoryRecipe> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}
