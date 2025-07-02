package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.DegreeType;
import io.gabo.schoolbridgeapi.dto.DegreeTypeDTO;
import io.gabo.schoolbridgeapi.repository.DegreeTypeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/degree-types")
public class DegreeTypeController {

    private final DegreeTypeRepository degreeTypeRepository;

    public DegreeTypeController(DegreeTypeRepository degreeTypeRepository) {
        this.degreeTypeRepository = degreeTypeRepository;
    }

    @GetMapping
    public List<DegreeTypeDTO> getAllDegreeTypes() {
        return degreeTypeRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DegreeTypeDTO> getDegreeTypeById(@PathVariable Long id) {
        Optional<DegreeType> degreeType = degreeTypeRepository.findById(id);
        return degreeType.map(value -> ResponseEntity.ok(toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<DegreeTypeDTO> getDegreeTypeByName(@PathVariable String name) {
        Optional<DegreeType> degreeType = degreeTypeRepository.findByNameIgnoreCase(name);
        return degreeType.map(value -> ResponseEntity.ok(toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DegreeTypeDTO createDegreeType(@RequestBody DegreeTypeDTO degreeTypeDTO) {
        DegreeType degreeType = fromDTO(degreeTypeDTO);
        DegreeType saved = degreeTypeRepository.save(degreeType);
        return toDTO(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DegreeTypeDTO> updateDegreeType(@PathVariable Long id, @RequestBody DegreeTypeDTO updatedDegreeTypeDTO) {
        return degreeTypeRepository.findById(id).map(degreeType -> {
            degreeType.setName(updatedDegreeTypeDTO.getName());
            degreeType.setDescription(updatedDegreeTypeDTO.getDescription());
            DegreeType saved = degreeTypeRepository.save(degreeType);
            return ResponseEntity.ok(toDTO(saved));
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

    // Helper methods for conversion

    private DegreeTypeDTO toDTO(DegreeType degreeType) {
        return new DegreeTypeDTO(degreeType.getId(), degreeType.getName(), degreeType.getDescription());
    }

    private DegreeType fromDTO(DegreeTypeDTO dto) {
        DegreeType degreeType = new DegreeType();
        degreeType.setId(dto.getId()); // optional, usually for update
        degreeType.setName(dto.getName());
        degreeType.setDescription(dto.getDescription());
        return degreeType;
    }
}
