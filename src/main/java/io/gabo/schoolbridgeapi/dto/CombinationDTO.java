package io.gabo.schoolbridgeapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationDTO {
    private Long id;
    private String code;
    private String description;
    private SectionDTO section;
    private List<CourseDTO> mainCourses;

    public CombinationDTO() {}

    public CombinationDTO(Long id, String code, String description, SectionDTO section, List<CourseDTO> mainCourses) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.section = section;
        this.mainCourses = mainCourses;
    }

    // Getters and setters

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

    public SectionDTO getSection() {
        return section;
    }
    public void setSection(SectionDTO section) {
        this.section = section;
    }

    public List<CourseDTO> getMainCourses() {
        return mainCourses;
    }
    public void setMainCourses(List<CourseDTO> mainCourses) {
        this.mainCourses = mainCourses;
    }

    public Long getSectionId() {
        return section != null ? section.getId() : null;
    }

    public Set<Long> getMainCourseIds() {
        if (mainCourses == null) return null;
        return mainCourses.stream().map(CourseDTO::getId).collect(Collectors.toSet());
    }
}
