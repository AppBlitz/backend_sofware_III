package com.restaurant.model.document;

import com.restaurant.model.Enum.RecipeStatus;
import com.restaurant.model.vo.Ingredient;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Document(collection ="recipe")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Recipe {
    @Id
    String  id;
    private String name;
    private List<Ingredient> ingredients;
    private String instructions;
    private int preparationTime;
    private int servings;
    private String comment;
    private LocalDate creationDate;
    private String recipeStatus;
}