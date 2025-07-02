package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.Section;
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
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Section> getSectionById(@PathVariable Long id) {
        Optional<Section> section = sectionRepository.findById(id);
        return section.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/education-level/{educationLevelId}")
    public List<Section> getSectionsByEducationLevel(@PathVariable Long educationLevelId) {
        return sectionRepository.findByEducationLevelId(educationLevelId);
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<Section> getSectionByName(@PathVariable String name) {
        Optional<Section> section = sectionRepository.findByNameIgnoreCase(name);
        return section.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
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
}
