package com.restaurant.model.document;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.restaurant.model.vo.MenuItem;

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
    String id;

    @NonNull
    String name;
    /**
     * A map of recipes and their respective prices in the menu.
     */
    @Builder.Default
    ArrayList<MenuItem> items = new ArrayList<>();

    /**
     * The date the menu was created.
     */
    @NonNull
    LocalDate date;

    @NonNull
    String description;

}
