package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "education_level_courses")
@Data
@NoArgsConstructor
class EducationLevelCourse {
    @EmbeddedId
    private EducationLevelCourseKey id;

    @ManyToOne(optional = false) @MapsId("educationLevelId")
    private EducationLevel educationLevel;
    @ManyToOne(optional = false) @MapsId("courseId")
    private Course course;
}


