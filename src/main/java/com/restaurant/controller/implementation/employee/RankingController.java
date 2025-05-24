package com.restaurant.controller.implementation.employee;
import com.restaurant.dto.employee.RankingDTO;
import com.restaurant.service.implementation.employees.RankingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employees/ranking")
public class RankingController {

    private final RankingService rankingService;

    public RankingController(RankingService rankingService) {
        this.rankingService = rankingService;
    }

    @GetMapping
    public List<RankingDTO> getAllRankings() {
        return rankingService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<RankingDTO> getRankingById(@PathVariable String id) {
        return rankingService.getById(id);
    }

    @GetMapping("/all/{idEmployee}")
    public List<RankingDTO> getAllByEmployeeId(@PathVariable String idEmployee) {
        return rankingService.getByEmployeeId(idEmployee);
    }

    @PostMapping
    public RankingDTO addRanking(@RequestBody RankingDTO rankingDTO) {
        return rankingService.addRanking(rankingDTO);
    }
}