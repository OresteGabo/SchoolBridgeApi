package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.School;
import io.gabo.schoolbridgeapi.repository.SchoolRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getSchoolById(@PathVariable Long id) {
        Optional<School> school = schoolRepository.findById(id);
        return school.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolRepository.save(school);
    }

    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody School updatedSchool) {
        return schoolRepository.findById(id).map(school -> {
            school.setName(updatedSchool.getName());
            school.setAbbrevName(updatedSchool.getAbbrevName());
            school.setLogoUrl(updatedSchool.getLogoUrl());
            school.setHasBoarding(updatedSchool.isHasBoarding());
            school.setContactPhone(updatedSchool.getContactPhone());
            school.setContactEmail(updatedSchool.getContactEmail());
            school.setWebsiteUrl(updatedSchool.getWebsiteUrl());
            school.setDistrict(updatedSchool.getDistrict());
            school.setSector(updatedSchool.getSector());
            School saved = schoolRepository.save(school);

            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        if (schoolRepository.existsById(id)) {
            schoolRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

