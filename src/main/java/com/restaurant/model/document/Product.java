package com.restaurant.model.document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@AllArgsConstructor
@Document("product")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Product {

    @Id
    String id;

    @NonNull
    String nameProduct;

    @Builder.Default
    ArrayList<String> suppliers = new ArrayList<>();

    @NonNull
    LocalDate dateExpiration;
    @NonNull
    LocalDate dateRegister;

    double weightProduct;
    double priceProduct;
    int stock;

    @Builder.Default
    List<byte[]> images = new ArrayList<>();
}
