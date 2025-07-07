package io.gabo.schoolbridgeapi.dto;

public class FollowedSchoolDTO {
    private Long schoolId;
    private String schoolName;

    public FollowedSchoolDTO(Long schoolId, String schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }
}

