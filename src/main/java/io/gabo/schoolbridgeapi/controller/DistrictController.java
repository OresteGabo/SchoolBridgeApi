package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.District;
import io.gabo.schoolbridgeapi.domain.Sector;
import io.gabo.schoolbridgeapi.dto.DistrictDTO;
import io.gabo.schoolbridgeapi.repository.DistrictRepository;
import io.gabo.schoolbridgeapi.repository.SectorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/districts")
public class DistrictController {

    private final DistrictRepository districtRepository;
    private final SectorRepository sectorRepository;

    public DistrictController(DistrictRepository districtRepository, SectorRepository sectorRepository) {
        this.districtRepository = districtRepository;
        this.sectorRepository = sectorRepository;
    }

    @GetMapping
    public List<DistrictDTO> getAllDistricts() {
        List<District> districts = districtRepository.findAll();
        return districts.stream()
                .map(this::toDTOWithSectorCount)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DistrictDTO> getDistrictById(@PathVariable Long id) {
        Optional<District> district = districtRepository.findById(id);
        return district.map(d -> ResponseEntity.ok(toDTOWithSectorCount(d)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DistrictDTO createDistrict(@RequestBody District district) {
        District saved = districtRepository.save(district);
        return toDTOWithSectorCount(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DistrictDTO> updateDistrict(@PathVariable Long id, @RequestBody District updatedDistrict) {
        return districtRepository.findById(id).map(district -> {
            district.setName(updatedDistrict.getName());
            District saved = districtRepository.save(district);
            return ResponseEntity.ok(toDTOWithSectorCount(saved));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {
        if (districtRepository.existsById(id)) {
            districtRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{districtId}/sectors")
    public ResponseEntity<List<Sector>> getSectorsByDistrictId(@PathVariable Long districtId) {
        if (!districtRepository.existsById(districtId)) {
            return ResponseEntity.notFound().build();
        }
        List<Sector> sectors = sectorRepository.findByDistrictId(districtId);
        return ResponseEntity.ok(sectors);
    }

    @GetMapping("/by-name/{districtName}/sectors")
    public ResponseEntity<List<Sector>> getSectorsByDistrictName(@PathVariable String districtName) {
        List<District> districts = districtRepository.findByName(districtName);
        if (districts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        // Just get sectors for the first district found (or aggregate if needed)
        District district = districts.getFirst(); // or handle differently if you want all sectors of all matching districts
        List<Sector> sectors = sectorRepository.findByDistrict(district);
        return ResponseEntity.ok(sectors);
    }


    // Helper to build DTO with sector count
    private DistrictDTO toDTOWithSectorCount(District district) {
        int sectorCount = sectorRepository.countByDistrictId(district.getId());
        return new DistrictDTO(district.getId(), district.getName(), sectorCount);
    }
}
