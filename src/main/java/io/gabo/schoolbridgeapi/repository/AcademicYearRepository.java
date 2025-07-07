package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.AcademicYear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface AcademicYearRepository
        extends JpaRepository<AcademicYear, Long> {

    /** Find the next academic year that starts after the given start date */
    Optional<AcademicYear> findFirstByStartDateAfterOrderByStartDateAsc(
            LocalDate currentStart
    );
}
