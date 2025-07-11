package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findByName(String name);
}
