package com.restaurant.repository;

import com.restaurant.model.document.Menu;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Optional;

/**
 * Repository interface for Menu documents.
 * Provides methods for CRUD operations and custom queries.
 */
@Repository
public interface MenuRepository extends MongoRepository<Menu, Integer> {

    /**
     * Finds a menu by its date.
     *
     * @param date The date of the menu to find.
     * @return An Optional containing the found menu, or empty if no menu is found.
     */
    Optional<Menu> findByDate(@NonNull LocalTime date);
}
