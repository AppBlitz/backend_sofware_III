package com.restaurant.model.document;

import java.time.LocalDate;
import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

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
    LocalDate date;

    @NonNull
    String name;

    @NonNull
    String description;

    double price;
    int amount;
    int rest;
}
