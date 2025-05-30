package com.restaurant.repository;

import com.restaurant.model.document.Ranking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends MongoRepository<Ranking, String> {
    List<Ranking> findByIdEmployee(String idEmployee);
}