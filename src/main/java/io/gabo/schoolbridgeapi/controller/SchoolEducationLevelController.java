package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.SchoolEducationLevel;
import io.gabo.schoolbridgeapi.domain.SchoolEducationLevelKey;
import io.gabo.schoolbridgeapi.dto.SchoolEducationLevelDTO;
import io.gabo.schoolbridgeapi.repository.SchoolEducationLevelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools-education-levels")
public class SchoolEducationLevelController {

    private final SchoolEducationLevelRepository repository;

    public SchoolEducationLevelController(SchoolEducationLevelRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<SchoolEducationLevel> getAll() {
        return repository.findAll();
    }

    @GetMapping("/by-school/{schoolId}")
    public List<SchoolEducationLevelDTO> getBySchool(@PathVariable Long schoolId) {
        List<SchoolEducationLevel> entities = repository.findBySchoolId(schoolId);

        return entities.stream()
                .map(e -> new SchoolEducationLevelDTO(
                        e.getSchool().getId(),
                        e.getSchool().getName(),
                        e.getEducationLevel().getId(),
                        e.getEducationLevel().getDescription()
                ))
                .toList(); // Or .collect(Collectors.toList()) in older Java versions
    }

    @GetMapping("/by-education-level/{educationLevelId}")
    public List<SchoolEducationLevel> getByEducationLevel(@PathVariable Long educationLevelId) {
        return repository.findByEducationLevelId(educationLevelId);
    }

    @GetMapping("/{schoolId}/{educationLevelId}")
    public ResponseEntity<SchoolEducationLevel> getById(@PathVariable Long schoolId, @PathVariable Long educationLevelId) {
        SchoolEducationLevelKey key = new SchoolEducationLevelKey();
        key.setSchoolId(schoolId);
        key.setEducationLevelId(educationLevelId);
        return repository.findById(key)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public SchoolEducationLevel create(@RequestBody SchoolEducationLevel schoolEducationLevel) {
        return repository.save(schoolEducationLevel);
    }

    @DeleteMapping("/{schoolId}/{educationLevelId}")
    public ResponseEntity<Void> delete(@PathVariable Long schoolId, @PathVariable Long educationLevelId) {
        SchoolEducationLevelKey key = new SchoolEducationLevelKey();
        key.setSchoolId(schoolId);
        key.setEducationLevelId(educationLevelId);
        if (repository.existsById(key)) {
            repository.deleteById(key);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
