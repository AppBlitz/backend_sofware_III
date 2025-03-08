package com.restaurant.model.document;

import com.restaurant.Enum.RecipeStatus;
import com.restaurant.model.vo.Ingredient;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalTime;
import java.util.ArrayList;

@AllArgsConstructor
@Document(collection ="recipe")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Recipe {
    @Id
    Integer id;
    @NonNull
    String name;
    @NonNull
    ArrayList<Ingredient> ingredients;
    @NonNull
    ArrayList<String> instructions;
    @NonNull
    LocalTime preparationTime;
    @NonNull
    Integer servings;
    @NonNull
    String comment;
    @NonNull
    LocalTime creationDate;
    @NonNull
    RecipeStatus recipeStatus;
}