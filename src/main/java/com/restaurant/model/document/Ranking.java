package com.restaurant.model.document;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@AllArgsConstructor
@Document(collection = "ranking")
@Builder
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Ranking {
    @Id
    @NotBlank()
    String id;
    @NotBlank()
    String idEmployee;
    @NotBlank()
    @Max(value = 5, message = "max")
    @Min(value = 1, message = "min")
    Integer rank;
    @NotBlank()
    LocalDate date;



}
