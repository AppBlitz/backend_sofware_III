package com.restaurant.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Document("producto")
@Builder
@NoArgsConstructor
@ToString
@Data
public class Producto {

    @Id
    String id;

    @NonNull
    String nombreProducto;

    double pesoProducto;

    @NonNull
    String[] proveedores;

    int cantidad;
}
