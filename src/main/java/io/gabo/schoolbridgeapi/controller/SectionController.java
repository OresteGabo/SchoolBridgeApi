package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.Section;
import io.gabo.schoolbridgeapi.dto.SectionDTO;
import io.gabo.schoolbridgeapi.repository.SectionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sections")
public class SectionController {

    private final SectionRepository sectionRepository;

    public SectionController(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;
    }

    @GetMapping
    public List<SectionDTO> getAllSections() {
        return sectionRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SectionDTO> getSectionById(@PathVariable Long id) {
        return sectionRepository.findById(id)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }




    @GetMapping("/education-level/{educationLevelId}")
    public List<SectionDTO> getSectionsByEducationLevel(@PathVariable Long educationLevelId) {
        return sectionRepository.findByEducationLevelId(educationLevelId).stream()
                .map(this::toDTO)
                .toList();
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<SectionDTO> getSectionByName(@PathVariable String name) {
        return sectionRepository.findByNameIgnoreCase(name)
                .map(this::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public Section createSection(@RequestBody Section section) {
        return sectionRepository.save(section);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Section> updateSection(@PathVariable Long id, @RequestBody Section updatedSection) {
        return sectionRepository.findById(id).map(section -> {
            section.setName(updatedSection.getName());
            section.setEducationLevel(updatedSection.getEducationLevel());
            Section saved = sectionRepository.save(section);
            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSection(@PathVariable Long id) {
        if (sectionRepository.existsById(id)) {
            sectionRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


    private SectionDTO toDTO(Section section) {
        return new SectionDTO(
                section.getId(),
                section.getName(),
                section.getEducationLevel().getDegreeType().getName()
        );
    }
}
