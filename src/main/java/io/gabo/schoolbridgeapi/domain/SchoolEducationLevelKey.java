package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable @NoArgsConstructor
public class SchoolEducationLevelKey {
    private Long schoolId;
    private Long educationLevelId;

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getEducationLevelId() {
        return educationLevelId;
    }

    public void setEducationLevelId(Long educationLevelId) {
        this.educationLevelId = educationLevelId;
    }
}
