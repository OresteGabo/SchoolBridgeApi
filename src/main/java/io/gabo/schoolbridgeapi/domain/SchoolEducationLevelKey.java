package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable @Data @NoArgsConstructor
class SchoolEducationLevelKey {
    private Long schoolId;
    private Long educationLevelId;
}
