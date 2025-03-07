package com.restaurant.repository;

import com.restaurant.model.document.Menu;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface MenuRepository extends MongoRepository<Menu, Integer>{
    Optional<Menu> findByFecha(@NonNull LocalTime fecha);
}
