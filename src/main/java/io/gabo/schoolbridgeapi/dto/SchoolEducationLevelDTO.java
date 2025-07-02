package io.gabo.schoolbridgeapi.dto;

public class SchoolEducationLevelDTO {
    private Long schoolId;
    private String schoolName;
    private Long educationLevelId;
    private String educationLevelName;

    public SchoolEducationLevelDTO(Long schoolId, String schoolName,
                                   Long educationLevelId, String educationLevelName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.educationLevelId = educationLevelId;
        this.educationLevelName = educationLevelName;
    }

    // Getters and setters
    public Long getSchoolId() { return schoolId; }
    public void setSchoolId(Long schoolId) { this.schoolId = schoolId; }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    public Long getEducationLevelId() { return educationLevelId; }
    public void setEducationLevelId(Long educationLevelId) { this.educationLevelId = educationLevelId; }

    public String getEducationLevelName() { return educationLevelName; }
    public void setEducationLevelName(String educationLevelName) { this.educationLevelName = educationLevelName; }
}

