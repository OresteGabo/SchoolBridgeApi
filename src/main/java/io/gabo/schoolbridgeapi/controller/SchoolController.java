package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.School;
import io.gabo.schoolbridgeapi.domain.Sector;
import io.gabo.schoolbridgeapi.dto.SchoolDTO;
import io.gabo.schoolbridgeapi.repository.SchoolRepository;
import io.gabo.schoolbridgeapi.repository.SectorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolRepository schoolRepository;
    private final SectorRepository sectorRepository;

    public SchoolController(SchoolRepository schoolRepository, SectorRepository sectorRepository) {
        this.schoolRepository = schoolRepository;
        this.sectorRepository = sectorRepository;
    }

    @GetMapping
    public List<SchoolDTO> getAllSchools() {
        return schoolRepository.findAll()
                .stream()
                .map(SchoolDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolDTO> getSchoolById(@PathVariable Long id) {
        return schoolRepository.findById(id)
                .map(school -> ResponseEntity.ok(new SchoolDTO(school)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SchoolDTO> createSchool(@RequestBody SchoolDTO dto) {
        Optional<Sector> sectorOpt = sectorRepository.findByNameIgnoreCase(dto.getSectorName());
        if (sectorOpt.isEmpty()) return ResponseEntity.badRequest().build();

        School school = toEntity(dto, sectorOpt.get());
        School saved = schoolRepository.save(school);
        return ResponseEntity.ok(new SchoolDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SchoolDTO> updateSchool(@PathVariable Long id, @RequestBody SchoolDTO dto) {
        Optional<School> existingOpt = schoolRepository.findById(id);
        Optional<Sector> sectorOpt = sectorRepository.findByNameIgnoreCase(dto.getSectorName());

        if (existingOpt.isEmpty() || sectorOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        School school = existingOpt.get();
        Sector sector = sectorOpt.get();

        // update fields
        school.setName(dto.getName());
        school.setAbbrevName(dto.getAbbrevName());
        school.setLogoUrl(dto.getLogoUrl());
        school.setContactPhone(dto.getContactPhone());
        school.setContactEmail(dto.getContactEmail());
        school.setWebsiteUrl(dto.getWebsiteUrl());
        school.setSector(sector);
        school.setDistrict(sector.getDistrict());

        School saved = schoolRepository.save(school);
        return ResponseEntity.ok(new SchoolDTO(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        if (schoolRepository.existsById(id)) {
            schoolRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Helper to map DTO → Entity
    private School toEntity(SchoolDTO dto, Sector sector) {
        School school = new School();
        school.setName(dto.getName());
        school.setAbbrevName(dto.getAbbrevName());
        school.setLogoUrl(dto.getLogoUrl());
        school.setContactPhone(dto.getContactPhone());
        school.setContactEmail(dto.getContactEmail());
        school.setWebsiteUrl(dto.getWebsiteUrl());
        school.setSector(sector);
        school.setDistrict(sector.getDistrict());
        return school;
    }
}
