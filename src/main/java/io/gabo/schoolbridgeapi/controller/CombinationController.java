package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.Combination;
import io.gabo.schoolbridgeapi.domain.Course;
import io.gabo.schoolbridgeapi.domain.EducationLevel;
import io.gabo.schoolbridgeapi.dto.CombinationDTO;
import io.gabo.schoolbridgeapi.dto.CourseDTO;
import io.gabo.schoolbridgeapi.repository.CombinationRepository;
import io.gabo.schoolbridgeapi.repository.CourseRepository;
import io.gabo.schoolbridgeapi.repository.EducationLevelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/combinations")
public class CombinationController {

    private final CombinationRepository combinationRepository;
    private final CourseRepository courseRepository;
    private final EducationLevelRepository educationLevelRepository;

    public CombinationController(
            CombinationRepository combinationRepository,
            CourseRepository courseRepository,
            EducationLevelRepository educationLevelRepository
    ) {
        this.combinationRepository = combinationRepository;
        this.courseRepository = courseRepository;
        this.educationLevelRepository = educationLevelRepository;
    }

    @GetMapping
    public List<CombinationDTO> getAllCombinations() {
        List<Combination> combinations = combinationRepository.findAll();
        combinations.forEach(c -> {
            c.getMainCourses().size();
            if (c.getEducationLevel() != null && c.getEducationLevel().getDegreeType() != null) {
                c.getEducationLevel().getDegreeType().getName();
            }
        });
        return combinations.stream().map(this::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CombinationDTO> getCombinationById(@PathVariable Long id) {
        return combinationRepository.findById(id)
                .map(value -> ResponseEntity.ok(toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-code/{code}")
    public ResponseEntity<CombinationDTO> getCombinationByCode(@PathVariable String code) {
        return combinationRepository.findByCodeIgnoreCase(code)
                .map(value -> ResponseEntity.ok(toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CombinationDTO createCombination(@RequestBody CombinationDTO dto) {
        Combination combination = fromDTO(dto);
        Combination saved = combinationRepository.save(combination);
        return toDTO(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CombinationDTO> updateCombination(@PathVariable Long id, @RequestBody CombinationDTO dto) {
        return combinationRepository.findById(id).map(existing -> {
            existing.setCode(dto.getCode());
            existing.setDescription(dto.getDescription());

            // Set Education Level
            if (dto.getEducationLevelId() != null) {
                educationLevelRepository.findById(dto.getEducationLevelId())
                        .ifPresent(existing::setEducationLevel);
            }

            // Update main courses
            if (dto.getMainCourses() != null) {
                Set<Course> courses = new HashSet<>();
                for (CourseDTO courseDTO : dto.getMainCourses()) {
                    if (courseDTO.getId() != null) {
                        courseRepository.findById(courseDTO.getId()).ifPresent(courses::add);
                    }
                }
                existing.setMainCourses(courses);
            } else {
                existing.setMainCourses(Collections.emptySet());
            }

            Combination saved = combinationRepository.save(existing);
            return ResponseEntity.ok(toDTO(saved));
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

    // --- Mapping Helpers ---

    private CombinationDTO toDTO(Combination combination) {
        String educationLevelName = combination.getEducationLevel() != null &&
                combination.getEducationLevel().getDegreeType() != null
                ? combination.getEducationLevel().getDegreeType().getName()
                : null;

        List<CourseDTO> courseDTOs = combination.getMainCourses().stream()
                .map(c -> new CourseDTO(c.getId(), c.getName(), c.getDescription()))
                .collect(Collectors.toList());

        return new CombinationDTO(
                combination.getId(),
                combination.getCode(),
                combination.getDescription(),
                combination.getEducationLevel() != null ? combination.getEducationLevel().getId() : null,
                educationLevelName,
                courseDTOs
        );
    }

    private Combination fromDTO(CombinationDTO dto) {
        Combination combination = new Combination();
        combination.setCode(dto.getCode());
        combination.setDescription(dto.getDescription());

        if (dto.getEducationLevelId() != null) {
            educationLevelRepository.findById(dto.getEducationLevelId())
                    .ifPresent(combination::setEducationLevel);
        }

        if (dto.getMainCourses() != null) {
            Set<Course> courses = dto.getMainCourses().stream()
                    .map(courseDTO -> {
                        if (courseDTO.getId() != null) {
                            return courseRepository.findById(courseDTO.getId()).orElse(null);
                        }
                        return null;
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toSet());
            combination.setMainCourses(courses);
        } else {
            combination.setMainCourses(Collections.emptySet());
        }

        return combination;
    }
}
