package com.restaurant.model.document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.model.Enum.Estate;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String id;
    @NotNull
    private String nameProduct;
    private ArrayList<String> suppliers;
    @NotNull
    private ArrayList<LocalDate> dateExpiration;
    @NotNull
    private ArrayList<Integer> controldateExpiration;
    @NotNull
    private LocalDate dateRegister;
    @NotNull
    private double weightProduct;
    @NotNull
    private double priceProduct;
    @NotNull
    private int stock;

    private List<byte[]> images;

    private Estate estate;

    @NonNull
    private String typeStock;

    //200 ok
}
