package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.EducationLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EducationLevelRepository extends JpaRepository<EducationLevel, Long> {

    // Used for promotion logic
    Optional<EducationLevel> findFirstByLevelOrderGreaterThanOrderByLevelOrderAsc(Integer currentOrder);

    // For your controller
    List<EducationLevel> findByDegreeType_NameIgnoreCaseOrderByLevelOrderAsc(String degreeTypeName);
}
