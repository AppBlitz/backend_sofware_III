package com.restaurant.model.document;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

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

    @NonNull
    ArrayList<String> suppliers;

    @NonNull
    LocalDate dateExpiration;
    @NonNull
    LocalDate dateRegister;

    double weightProduct;
    int amount;
}
