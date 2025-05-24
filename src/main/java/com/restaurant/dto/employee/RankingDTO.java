package com.restaurant.dto.employee;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RankingDTO {
    @NotBlank
    private String idEmployee;

    @Max(value = 5, message = "max")
    @Min(value = 1, message = "min")
    private Integer rank;

    @NotBlank
    private LocalDate date;
}