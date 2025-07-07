package io.gabo.schoolbridgeapi.dto;

import io.gabo.schoolbridgeapi.dto.CourseDTO;

import java.util.List;

public class CombinationDTO {
    private Long id;
    private String code;
    private String description;

    private Long educationLevelId;
    private String educationLevelName;

    private List<CourseDTO> mainCourses;

    public CombinationDTO(
            Long id,
            String code,
            String description,
            Long educationLevelId,
            String educationLevelName,
            List<CourseDTO> mainCourses
    ) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.educationLevelId = educationLevelId;
        this.educationLevelName = educationLevelName;
        this.mainCourses = mainCourses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEducationLevelId() {
        return educationLevelId;
    }

    public void setEducationLevelId(Long educationLevelId) {
        this.educationLevelId = educationLevelId;
    }

    public String getEducationLevelName() {
        return educationLevelName;
    }

    public void setEducationLevelName(String educationLevelName) {
        this.educationLevelName = educationLevelName;
    }

    public List<CourseDTO> getMainCourses() {
        return mainCourses;
    }

    public void setMainCourses(List<CourseDTO> mainCourses) {
        this.mainCourses = mainCourses;
    }
}
