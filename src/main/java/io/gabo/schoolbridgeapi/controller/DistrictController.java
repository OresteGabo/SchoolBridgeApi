package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.District;
import io.gabo.schoolbridgeapi.domain.Sector;
import io.gabo.schoolbridgeapi.repository.DistrictRepository;
import io.gabo.schoolbridgeapi.repository.SectorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

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
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable Long id) {
        Optional<District> district = districtRepository.findById(id);
        return district.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public District createDistrict(@RequestBody District district) {
        return districtRepository.save(district);
    }

    @PutMapping("/{id}")
    public ResponseEntity<District> updateDistrict(@PathVariable Long id, @RequestBody District updatedDistrict) {
        return districtRepository.findById(id).map(district -> {
            district.setName(updatedDistrict.getName());
            District saved = districtRepository.save(district);
            return ResponseEntity.ok(saved);
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

    // Get sectors by district ID
    @GetMapping("/{districtId}/sectors")
    public ResponseEntity<List<Sector>> getSectorsByDistrictId(@PathVariable Long districtId) {
        if (!districtRepository.existsById(districtId)) {
            return ResponseEntity.notFound().build();
        }
        List<Sector> sectors = sectorRepository.findByDistrictId(districtId);
        return ResponseEntity.ok(sectors);
    }

    // Get sectors by district name (assuming district names are unique)
    //TODO this is not working, have to debug later
    @GetMapping("/by-name/{districtName}/sectors")
    public ResponseEntity<List<Sector>> getSectorsByDistrictName(@PathVariable String districtName) {
        return districtRepository.findByName(districtName)
                .map(district -> {
                    List<Sector> sectors = sectorRepository.findByDistrict(district);
                    if (sectors.isEmpty()) {
                        System.out.println("No sectors found for district: " + districtName );
                    }else{
                        System.out.println("Found " + sectors.size() + " sectors for district: " + districtName );
                    }
                    return ResponseEntity.ok(sectors);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}

