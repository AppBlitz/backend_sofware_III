package com.restaurant.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sale {

    @Id
    String id;

    @NonNull
    String idShoppingCart;

    @NonNull
    String idCashier;

    @NonNull
    LocalDateTime date;

    @NonNull
    String paymentMethod;

    @NonNull
    double amount;
}
