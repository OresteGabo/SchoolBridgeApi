package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;



@Entity(name = "school_level_offerings")  @Data @NoArgsConstructor
class SchoolLevelOffering {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional = false) private School school;
    @ManyToOne(optional = false) private EducationLevel educationLevel;
    @ManyToOne(optional = false) private AcademicYear academicYear;

    @OneToMany(mappedBy = "offering", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SchoolExtraCourse> extraCourses = new HashSet<>();
}

