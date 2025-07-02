package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.District;
import io.gabo.schoolbridgeapi.domain.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {
    List<Sector> findByDistrictId(Long districtId);
    List<Sector> findByDistrict(District district);
    int countByDistrictId(Long districtId);
}