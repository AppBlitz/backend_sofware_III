package com.restaurant.repository;
import java.util.Optional;

import com.restaurant.Enum.EstadoReceta;
import com.restaurant.model.document.Receta;
import lombok.NonNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends MongoRepository<Receta, Integer> {
    Optional<Receta> findByNombre(@NonNull String nombre);
    Optional<Receta> findByEstadoReceta(@NonNull EstadoReceta estadoReceta);

}
