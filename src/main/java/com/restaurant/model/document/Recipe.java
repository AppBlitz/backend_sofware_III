package com.restaurant.model.document;

import java.time.LocalDate;
import java.util.List;

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
    String id;
    private String name;
    private List<Ingredient> ingredients;
    private String instructions;
    private int preparationTime;
    private int servings;
    private String comment;
    private LocalDate creationDate;
    private String recipeStatus;
}
