package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.Sector;
import io.gabo.schoolbridgeapi.repository.SectorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sectors")
public class SectorController {

    private final SectorRepository sectorRepository;

    public SectorController(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    @GetMapping
    public List<Sector> getAllSectors() {
        return sectorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sector> getSectorById(@PathVariable Long id) {
        Optional<Sector> sector = sectorRepository.findById(id);
        return sector.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Optional: Get sectors by district ID
    @GetMapping("/by-district/{districtId}")
    public List<Sector> getSectorsByDistrictName(@PathVariable Long districtId) {
        return sectorRepository.findByDistrictId(districtId);
    }

    @PostMapping
    public Sector createSector(@RequestBody Sector sector) {
        return sectorRepository.save(sector);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sector> updateSector(@PathVariable Long id, @RequestBody Sector updatedSector) {
        return sectorRepository.findById(id).map(sector -> {
            sector.setName(updatedSector.getName());
            sector.setDistrict(updatedSector.getDistrict());
            Sector saved = sectorRepository.save(sector);
            return ResponseEntity.ok(saved);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSector(@PathVariable Long id) {
        if (sectorRepository.existsById(id)) {
            sectorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

