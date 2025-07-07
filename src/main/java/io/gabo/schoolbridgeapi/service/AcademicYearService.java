package io.gabo.schoolbridgeapi.service;

import io.gabo.schoolbridgeapi.domain.AcademicYear;
import io.gabo.schoolbridgeapi.repository.AcademicYearRepository;
import org.springframework.stereotype.Service;

@Service
public class AcademicYearService {

    private final AcademicYearRepository yearRepo;

    public AcademicYearService(AcademicYearRepository yearRepo) {
        this.yearRepo = yearRepo;
    }

    /** Return the next chronological academic year; throws if none exists. */
    public AcademicYear getNext(AcademicYear current) {
        return yearRepo
                .findFirstByStartDateAfterOrderByStartDateAsc(current.getStartDate())
                .orElseThrow(() ->
                        new IllegalStateException("No next academic year found after " + current.getStartDate()));
    }
}
