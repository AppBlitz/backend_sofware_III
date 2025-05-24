package com.restaurant.mapping;

import com.restaurant.dto.employee.RankingDTO;
import com.restaurant.model.document.Ranking;

public class RankingMapper {
    public static Ranking toEntity(RankingDTO dto) {
        return Ranking.builder()
                .idEmployee(dto.getIdEmployee())
                .rank(dto.getRank())
                .date(dto.getDate())
                .build();
    }

    public static RankingDTO toDTO(Ranking ranking) {
        return RankingDTO.builder()
                .idEmployee(ranking.getIdEmployee())
                .rank(ranking.getRank())
                .date(ranking.getDate())
                .build();
    }
}