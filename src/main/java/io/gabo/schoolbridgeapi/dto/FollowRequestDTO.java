package io.gabo.schoolbridgeapi.dto;

public class FollowRequestDTO {
    private Long userId;
    private Long schoolId;

    public FollowRequestDTO() {}

    public FollowRequestDTO(Long userId, Long schoolId) {
        this.userId = userId;
        this.schoolId = schoolId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getSchoolId() {
        return schoolId;
    }
}

