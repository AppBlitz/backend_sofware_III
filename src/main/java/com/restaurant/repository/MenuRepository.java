package com.restaurant.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurant.model.document.Menu;

import lombok.NonNull;

/**
 * Repository interface for Menu documents.
 * Provides methods for CRUD operations and custom queries.
 */
@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {

    /**
     * Finds a menu by its date.
     *
     * @param date The date of the menu to find.
     * @return An Optional containing the found menu, or empty if no menu is found.
     */
    @Query("{ 'date' : ?0 }")
    Optional<Menu> findByDate(@NonNull LocalDate date);

    @Query("{ 'date' : ?0 }")
    List<Menu> findByDates(@NonNull LocalDate date);

    @Query("{ '_id' }")
    Optional<Menu> findById(String id);

    @Query(" { '_id' : ?0 }")
    void deleteByid(String id);

}
