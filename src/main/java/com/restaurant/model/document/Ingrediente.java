package com.restaurant.model.document;
import lombok.*;
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Ingrediente {
    @NonNull
    Product producto;
    @NonNull
    Integer cant;
    @NonNull
    String unidadesMedida;
    @NonNull
    String notasAdicionales;
}
