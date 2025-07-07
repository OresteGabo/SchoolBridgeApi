package io.gabo.schoolbridgeapi.service;

import io.gabo.schoolbridgeapi.domain.*;
import io.gabo.schoolbridgeapi.repository.SchoolLevelOfferingRepository;
import io.gabo.schoolbridgeapi.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EnrollmentService {

    private final UserRepository userRepo;
    private final SchoolLevelOfferingRepository offeringRepo;
    private final EducationLevelService levelService;
    private final AcademicYearService yearService;

    public EnrollmentService(UserRepository userRepo,
                             SchoolLevelOfferingRepository offeringRepo,
                             EducationLevelService levelService,
                             AcademicYearService yearService) {
        this.userRepo = userRepo;
        this.offeringRepo = offeringRepo;
        this.levelService = levelService;
        this.yearService = yearService;
    }

    /** Promote a learner (ROLE_STUDENT) to the next level & year. */
    @Transactional
    public void promoteStudent(Long userId) {

        User learner = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (!learner.hasRole("STUDENT")) {
            throw new IllegalStateException("User is not a student");
        }

        StudentEnrollment current = learner.getCurrentEnrollment()
                .orElseThrow(() -> new IllegalStateException("Student has no active enrollment"));

        // Close current enrollment
        current.setCurrent(false);
        current.setLeftOn(LocalDate.now());

        // Determine next level + year
        EducationLevel nextLevel = levelService.getNext(current.getOffering().getEducationLevel());
        AcademicYear nextYear = yearService.getNext(current.getOffering().getAcademicYear());

        // Fetch the target offering (same school/stream)
        SchoolLevelOffering nextOffering = offeringRepo
                .findBySchoolAndEducationLevelAndAcademicYearAndCombination(
                        current.getOffering().getSchool(),
                        nextLevel,
                        nextYear,
                        current.getOffering().getCombination()   // keep same stream
                )
                .orElseThrow(() -> new IllegalStateException(
                        "Next offering not configured for " + nextLevel + " in " + nextYear));

        // Create new enrollment
        StudentEnrollment next = new StudentEnrollment();
        next.setUser(learner);
        next.setOffering(nextOffering);  // current=true by default

        learner.getEnrollments().add(next);
    }
}
