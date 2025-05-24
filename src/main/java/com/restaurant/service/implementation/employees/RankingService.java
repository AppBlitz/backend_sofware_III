package com.restaurant.service.implementation.employees;

import com.restaurant.dto.employee.RankingDTO;
import com.restaurant.mapping.RankingMapper;
import com.restaurant.model.document.Ranking;
import com.restaurant.repository.RankingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RankingService {

    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    public List<RankingDTO> getAll() {
        return rankingRepository.findAll().stream()
                .map(RankingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<RankingDTO> getById(String id) {
        return rankingRepository.findById(id).map(RankingMapper::toDTO);
    }

    public List<RankingDTO> getByEmployeeId(String idEmployee) {
        return rankingRepository.findByIdEmployee(idEmployee).stream()
                .map(RankingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RankingDTO addRanking(RankingDTO rankingDTO) {
        Ranking ranking = rankingRepository.save(RankingMapper.toEntity(rankingDTO));
        return RankingMapper.toDTO(ranking);
    }
}
