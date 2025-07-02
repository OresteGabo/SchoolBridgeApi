package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor
@Table(name = "schools_education_levels")
public class SchoolEducationLevel {
    @EmbeddedId private SchoolEducationLevelKey id;

    @ManyToOne(optional = false) @MapsId("schoolId") private School school;
    @ManyToOne(optional = false) @MapsId("educationLevelId") private EducationLevel educationLevel;
}
