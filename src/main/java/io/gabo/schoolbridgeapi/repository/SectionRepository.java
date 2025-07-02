package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SectionRepository extends JpaRepository<Section, Long> {

    List<Section> findByEducationLevelId(Long educationLevelId);

    Optional<Section> findByNameIgnoreCase(String name);
}
