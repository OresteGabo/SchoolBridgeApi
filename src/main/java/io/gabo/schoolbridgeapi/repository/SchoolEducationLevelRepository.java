package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.SchoolEducationLevel;
import io.gabo.schoolbridgeapi.domain.SchoolEducationLevelKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchoolEducationLevelRepository extends JpaRepository<SchoolEducationLevel, SchoolEducationLevelKey> {
    List<SchoolEducationLevel> findBySchoolId(Long schoolId);
    List<SchoolEducationLevel> findByEducationLevelId(Long educationLevelId);
}

