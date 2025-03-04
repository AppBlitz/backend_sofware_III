package com.restaurant.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@Document("producto")
@Builder
@NoArgsConstructor
@ToString
public class Producto {

    @Id
    String id;

    @NonNull
    String nombreProducto;

    @NonNull
    double pesoProducto;

    @NonNull
    String[] proveedores;

    @NonNull
    int cantidad;






}
