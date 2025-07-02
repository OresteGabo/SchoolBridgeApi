package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor
@Table(name = "schools_education_levels")
public class SchoolEducationLevel {
    @EmbeddedId private SchoolEducationLevelKey id;

    @ManyToOne(optional = false) @MapsId("schoolId") private School school;
    @ManyToOne(optional = false) @MapsId("educationLevelId") private EducationLevel educationLevel;

    public SchoolEducationLevelKey getId() {
        return id;
    }

    public void setId(SchoolEducationLevelKey id) {
        this.id = id;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }
}
