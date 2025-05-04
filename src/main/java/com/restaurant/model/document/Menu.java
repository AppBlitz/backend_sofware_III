package com.restaurant.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.HashMap;

/**
 * Represents a menu in the restaurant.
 */
@AllArgsConstructor
@Document(collection = "menu")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Menu {

    /**
     * The unique identifier for the menu.
     */
    @Id
    Integer id;

    /**
     * A map of recipes and their respective prices in the menu.
     */
    @NonNull
    HashMap<String, Recipe> menuItems;

    /**
     * The date the menu was created.
     */
    @NonNull
    LocalTime date;

    double price;
    int amount;
    int rest;
}
