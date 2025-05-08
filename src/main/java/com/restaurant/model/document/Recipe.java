package com.restaurant.model.document;

import java.time.LocalDate;
import java.util.List;

import com.restaurant.model.Enum.Estate;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.restaurant.model.vo.Ingredient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Document(collection = "recipe")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Recipe {
    @Id
    @NotNull
    public String id;
    @NotNull
    private String name;
    @NotNull
    private List<Ingredient> ingredients;
    @NotNull
    private String instructions;
    @NotNull
    private int preparationTime;
    @NotNull
    private int servings;

    private String comment;
    @NotNull
    private LocalDate creationDate;
    @NotNull
    private Estate estate;

    private double price;
}
