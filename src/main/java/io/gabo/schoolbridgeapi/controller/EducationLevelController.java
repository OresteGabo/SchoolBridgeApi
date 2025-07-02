package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.EducationLevel;
import io.gabo.schoolbridgeapi.repository.EducationLevelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/education-levels")
public class EducationLevelController {

    private final EducationLevelRepository educationLevelRepository;

    public EducationLevelController(EducationLevelRepository educationLevelRepository) {
        this.educationLevelRepository = educationLevelRepository;
    }

    @GetMapping
    public List<EducationLevel> getAllEducationLevels() {
        return educationLevelRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationLevel> getEducationLevelById(@PathVariable Long id) {
        Optional<EducationLevel> educationLevel = educationLevelRepository.findById(id);
        return educationLevel.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public EducationLevel createEducationLevel(@RequestBody EducationLevel educationLevel) {
        return educationLevelRepository.save(educationLevel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EducationLevel> updateEducationLevel(@PathVariable Long id, @RequestBody EducationLevel updatedEducationLevel) {
        return educationLevelRepository.findById(id).map(educationLevel -> {
            educationLevel.setDegreeType(updatedEducationLevel.getDegreeType());
            educationLevel.setDescription(updatedEducationLevel.getDescription());
            educationLevel.setLevelOrder(updatedEducationLevel.getLevelOrder());
            EducationLevel saved = educationLevelRepository.save(educationLevel);
            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducationLevel(@PathVariable Long id) {
        if (educationLevelRepository.existsById(id)) {
            educationLevelRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
