package com.restaurant.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.HashMap;

@AllArgsConstructor
@Document("menu")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Menu {
    @Id
    Integer id;
    @NonNull
    HashMap<Receta,Double> productosMenu;
    @NonNull
    LocalTime Fecha;
}
