package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.DegreeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DegreeTypeRepository extends JpaRepository<DegreeType, Long> {
    Optional<DegreeType> findByNameIgnoreCase(String name);
}

