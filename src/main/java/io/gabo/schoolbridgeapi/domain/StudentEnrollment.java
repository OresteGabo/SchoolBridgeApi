package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student_enrollments",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"user_id","offering_id"}
        ))
@Data @NoArgsConstructor
public class StudentEnrollment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The learner.  Must have ROLE_STUDENT, enforce in service layer or DB CHECK. */
    @ManyToOne(optional = false)
    private User user;

    /** Where + when + level they are enrolled. */
    @ManyToOne(optional = false)
    private SchoolLevelOffering offering;

    /** Only one row per user should have current=true. */
    private boolean current = true;

    private LocalDate enrolledOn = LocalDate.now();
    private LocalDate leftOn;    // set on promotion, withdrawal, etc.
}


