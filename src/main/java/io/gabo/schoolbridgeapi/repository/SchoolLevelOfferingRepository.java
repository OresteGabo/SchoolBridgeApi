package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolLevelOfferingRepository
        extends JpaRepository<SchoolLevelOffering, Long> {

    /**
     * Find a specific offering (school + level + year + combination).
     * Pass `null` for combination when streams are not used.
     */
    Optional<SchoolLevelOffering> findBySchoolAndEducationLevelAndAcademicYearAndCombination(
            School school,
            EducationLevel educationLevel,
            AcademicYear academicYear,
            String combination
    );
}
