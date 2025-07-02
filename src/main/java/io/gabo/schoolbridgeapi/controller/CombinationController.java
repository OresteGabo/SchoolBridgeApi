package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.Combination;
import io.gabo.schoolbridgeapi.domain.Course;
import io.gabo.schoolbridgeapi.domain.Section;
import io.gabo.schoolbridgeapi.dto.CombinationDTO;
import io.gabo.schoolbridgeapi.dto.CourseDTO;
import io.gabo.schoolbridgeapi.dto.SectionDTO;
import io.gabo.schoolbridgeapi.repository.CombinationRepository;
import io.gabo.schoolbridgeapi.repository.CourseRepository;
import io.gabo.schoolbridgeapi.repository.SectionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/combinations")
public class CombinationController {

    private final CombinationRepository combinationRepository;
    private final SectionRepository sectionRepository;
    private final CourseRepository courseRepository;

    public CombinationController(CombinationRepository combinationRepository,
                                 SectionRepository sectionRepository,
                                 CourseRepository courseRepository) {
        this.combinationRepository = combinationRepository;
        this.sectionRepository = sectionRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping
    public List<CombinationDTO> getAllCombinations() {
        List<Combination> combinations = combinationRepository.findAll();
        // Force fetch of lazy collections
        combinations.forEach(c -> {
            c.getMainCourses().size();
            if (c.getSection() != null && c.getSection().getEducationLevel() != null) {
                c.getSection().getEducationLevel().getDegreeType().getName();
            }
        });
        return combinations.stream().map(this::toDTO).collect(Collectors.toList());
    }


    @GetMapping("/{id}")
    public ResponseEntity<CombinationDTO> getCombinationById(@PathVariable Long id) {
        Optional<Combination> combination = combinationRepository.findById(id);
        return combination.map(value -> ResponseEntity.ok(toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/by-code/{code}")
    public ResponseEntity<CombinationDTO> getCombinationByCode(@PathVariable String code) {
        Optional<Combination> combination = combinationRepository.findByCodeIgnoreCase(code);
        return combination.map(value -> ResponseEntity.ok(toDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CombinationDTO createCombination(@RequestBody CombinationDTO combinationDTO) {
        Combination combination = fromDTO(combinationDTO);
        Combination saved = combinationRepository.save(combination);
        return toDTO(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CombinationDTO> updateCombination(@PathVariable Long id,
                                                            @RequestBody CombinationDTO updatedCombinationDTO) {
        return combinationRepository.findById(id).map(existing -> {
            existing.setCode(updatedCombinationDTO.getCode());
            existing.setDescription(updatedCombinationDTO.getDescription());

            // Update Section if provided
            if (updatedCombinationDTO.getSection() != null && updatedCombinationDTO.getSection().getId() != null) {
                sectionRepository.findById(updatedCombinationDTO.getSection().getId())
                        .ifPresent(existing::setSection);
            }

            // Update main courses if provided
            if (updatedCombinationDTO.getMainCourses() != null) {
                Set<Course> courses = new HashSet<>();
                for (CourseDTO courseDTO : updatedCombinationDTO.getMainCourses()) {
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

    // --- Helper methods to convert between entity and DTO ---

    private CombinationDTO toDTO(Combination combination) {
        Section section = combination.getSection();
        SectionDTO sectionDTO = null;
        if (section != null) {
            String educationLevelName = null;
            if (section.getEducationLevel() != null && section.getEducationLevel().getDegreeType() != null) {
                educationLevelName = section.getEducationLevel().getDegreeType().getName();
            }
            sectionDTO = new SectionDTO(
                    section.getId(),
                    section.getName(),
                    educationLevelName
            );
        }

        List<CourseDTO> courseDTOs = combination.getMainCourses().stream()
                .map(c -> new CourseDTO(c.getId(), c.getName(), c.getDescription()))
                .collect(Collectors.toList());

        return new CombinationDTO(
                combination.getId(),
                combination.getCode(),
                combination.getDescription(),
                sectionDTO,
                courseDTOs
        );
    }


    private Combination fromDTO(CombinationDTO dto) {
        Combination combination = new Combination();
        combination.setCode(dto.getCode());
        combination.setDescription(dto.getDescription());

        if (dto.getSection() != null && dto.getSection().getId() != null) {
            sectionRepository.findById(dto.getSection().getId())
                    .ifPresent(combination::setSection);
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
