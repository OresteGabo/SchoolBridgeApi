package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.Combination;
import io.gabo.schoolbridgeapi.repository.CombinationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/combinations")
public class CombinationController {

    private final CombinationRepository combinationRepository;

    public CombinationController(CombinationRepository combinationRepository) {
        this.combinationRepository = combinationRepository;
    }

    @GetMapping
    public List<Combination> getAllCombinations() {
        return combinationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Combination> getCombinationById(@PathVariable Long id) {
        Optional<Combination> combination = combinationRepository.findById(id);
        return combination.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-code/{code}")
    public ResponseEntity<Combination> getCombinationByCode(@PathVariable String code) {
        Optional<Combination> combination = combinationRepository.findByCodeIgnoreCase(code);
        return combination.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Combination createCombination(@RequestBody Combination combination) {
        return combinationRepository.save(combination);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Combination> updateCombination(@PathVariable Long id, @RequestBody Combination updatedCombination) {
        return combinationRepository.findById(id).map(combination -> {
            combination.setCode(updatedCombination.getCode());
            combination.setDescription(updatedCombination.getDescription());
            combination.setSection(updatedCombination.getSection());
            combination.setMainCourses(updatedCombination.getMainCourses());
            Combination saved = combinationRepository.save(combination);
            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCombination(@PathVariable Long id) {
        if (combinationRepository.existsById(id)) {
            combinationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

