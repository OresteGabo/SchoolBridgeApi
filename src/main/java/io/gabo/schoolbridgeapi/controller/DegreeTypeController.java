package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.DegreeType;
import io.gabo.schoolbridgeapi.repository.DegreeTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/degree-types")
public class DegreeTypeController {

    private final DegreeTypeRepository degreeTypeRepository;

    public DegreeTypeController(DegreeTypeRepository degreeTypeRepository) {
        this.degreeTypeRepository = degreeTypeRepository;
    }

    @GetMapping
    public List<DegreeType> getAllDegreeTypes() {
        return degreeTypeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DegreeType> getDegreeTypeById(@PathVariable Long id) {
        Optional<DegreeType> degreeType = degreeTypeRepository.findById(id);
        return degreeType.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<DegreeType> getDegreeTypeByName(@PathVariable String name) {
        Optional<DegreeType> degreeType = degreeTypeRepository.findByNameIgnoreCase(name);
        return degreeType.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DegreeType createDegreeType(@RequestBody DegreeType degreeType) {
        return degreeTypeRepository.save(degreeType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DegreeType> updateDegreeType(@PathVariable Long id, @RequestBody DegreeType updatedDegreeType) {
        return degreeTypeRepository.findById(id).map(degreeType -> {
            degreeType.setName(updatedDegreeType.getName());
            degreeType.setDescription(updatedDegreeType.getDescription());
            DegreeType saved = degreeTypeRepository.save(degreeType);
            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDegreeType(@PathVariable Long id) {
        if (degreeTypeRepository.existsById(id)) {
            degreeTypeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
