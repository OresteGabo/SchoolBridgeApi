
package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.EducationLevel;
import io.gabo.schoolbridgeapi.dto.EducationLevelDTO;
import io.gabo.schoolbridgeapi.repository.EducationLevelRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/education-levels")
public class EducationLevelController {

    private final EducationLevelRepository educationLevelRepository;

    public EducationLevelController(EducationLevelRepository educationLevelRepository) {
        this.educationLevelRepository = educationLevelRepository;
    }

    @GetMapping("/by-degree-type/{name}")
    public ResponseEntity<List<EducationLevelDTO>> getByDegreeTypeName(@PathVariable String name) {

        List<EducationLevelDTO> result = educationLevelRepository
                .findByDegreeType_NameIgnoreCaseOrderByLevelOrderAsc(name)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());

        return result.isEmpty()
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(result);
    }

    private EducationLevelDTO toDto(EducationLevel level) {
        EducationLevelDTO dto = new EducationLevelDTO();
        dto.setId(level.getId());
        dto.setDegreeTypeName(level.getDegreeType().getName());
        dto.setDescription(level.getDescription());
        dto.setLevelOrder(level.getLevelOrder());
        return dto;
    }

}
