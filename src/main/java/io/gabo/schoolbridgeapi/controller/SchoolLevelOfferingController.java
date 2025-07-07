package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.*;
import io.gabo.schoolbridgeapi.repository.SchoolLevelOfferingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/school-level-offerings")
public class SchoolLevelOfferingController {

    private final SchoolLevelOfferingRepository offeringRepository;

    public SchoolLevelOfferingController(SchoolLevelOfferingRepository offeringRepository) {
        this.offeringRepository = offeringRepository;
    }

    /** Get all offerings */
    @GetMapping
    public List<SchoolLevelOffering> getAllOfferings() {
        return offeringRepository.findAll();
    }

    /** Get a specific offering by ID */
    @GetMapping("/{id}")
    public ResponseEntity<SchoolLevelOffering> getById(@PathVariable Long id) {
        return offeringRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** Get a specific offering by school, level, year, and combination */
    @GetMapping("/search")
    public ResponseEntity<SchoolLevelOffering> findByParams(
            @RequestParam Long schoolId,
            @RequestParam Long levelId,
            @RequestParam Long yearId,
            @RequestParam(required = false) String combination
    ) {
        School school = new School();
        school.setId(schoolId);

        EducationLevel level = new EducationLevel();
        level.setId(levelId);

        AcademicYear year = new AcademicYear();
        year.setId(yearId);

        Optional<SchoolLevelOffering> result = offeringRepository
                .findBySchoolAndEducationLevelAndAcademicYearAndCombination(
                        school, level, year, combination
                );

        return result.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** Create a new offering */
    @PostMapping
    public SchoolLevelOffering createOffering(@RequestBody SchoolLevelOffering offering) {
        return offeringRepository.save(offering);
    }

    /** Delete by ID */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (offeringRepository.existsById(id)) {
            offeringRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
