package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
class EducationLevelCourseKey {
    private Long educationLevelId;
    private Long courseId;
}
