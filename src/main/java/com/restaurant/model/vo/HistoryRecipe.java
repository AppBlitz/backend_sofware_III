package com.restaurant.model.vo;

import lombok.*;

import java.time.LocalDateTime;

@Data // Generates getters, setters, equals, hashCode, and toString methods
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-args constructor
@EqualsAndHashCode // Generates equals and hashCode methods based on all fields
@Builder // Allows for a builder pattern to create instances of this class

public class HistoryRecipe {

    @NonNull
    private String action;

    @NonNull
    private LocalDateTime timeStamp;


    private String details;

    //private String nameEmployee;

}
