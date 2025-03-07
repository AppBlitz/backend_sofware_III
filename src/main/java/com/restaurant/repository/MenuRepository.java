package com.restaurant.repository;

import com.restaurant.model.document.Menu;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalTime;
import java.util.Optional;

public interface MenuRepository extends MongoRepository<Menu, Integer>{
    Optional<Menu> findByFecha(@NonNull LocalTime fecha);
}
