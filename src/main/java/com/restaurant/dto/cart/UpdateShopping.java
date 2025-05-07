package com.restaurant.dto.cart;

import java.util.ArrayList;

import com.restaurant.model.vo.Items;

import jakarta.validation.constraints.Null;
import lombok.NonNull;

public record UpdateShopping(@NonNull String id, @Null ArrayList<Items> items) {
}
