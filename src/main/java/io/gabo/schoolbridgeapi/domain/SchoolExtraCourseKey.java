package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable @Data @NoArgsConstructor
class SchoolExtraCourseKey {
    private Long schoolLevelOfferingId;
    private Long courseId;
}