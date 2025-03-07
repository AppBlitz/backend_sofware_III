package com.restaurant.model.document;

import com.restaurant.Enum.EstadoReceta;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.ArrayList;

@AllArgsConstructor
@Document(collection ="receta")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Receta {
    @Id
    Integer id;
    @NonNull
    String nombre;
    @NonNull
    ArrayList<Ingrediente> ingredientes;
    @NonNull
    ArrayList<String> instrucciones;
    @NonNull
    LocalTime tiempoPreparacion;
    @NonNull
    Integer porciones;
    @NonNull
    String comentario;
    @NonNull
    LocalTime FechaCreacion;
    @NonNull
    EstadoReceta estadoReceta;
}
