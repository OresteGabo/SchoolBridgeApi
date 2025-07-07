package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
        name = "school_level_offerings",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"school_id", "education_level_id", "academic_year_id", "combination"}
        )
)
@Data
@NoArgsConstructor
public class SchoolLevelOffering {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private School school;

    @ManyToOne(optional = false)
    private EducationLevel educationLevel;   // e.g. S5

    @ManyToOne(optional = false)
    private AcademicYear academicYear;       // e.g. 2025‑2026

    /** Stream / option such as "MCB"; nullable when not applicable */
    @Column(length = 10)
    private String combination;

    // Example: extra optional courses the school attaches to that stream
    @OneToMany(
            mappedBy = "offering",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<SchoolExtraCourse> extraCourses = new HashSet<>();
}
