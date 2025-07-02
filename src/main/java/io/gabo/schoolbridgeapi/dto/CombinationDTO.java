package io.gabo.schoolbridgeapi.dto;

import io.gabo.schoolbridgeapi.domain.Combination;
import io.gabo.schoolbridgeapi.domain.Course;

import java.util.Set;
import java.util.stream.Collectors;

public class CombinationDTO {
    private Long id;
    private String code;
    private String description;
    private String sectionName;
    private Set<String> courseNames;

    public CombinationDTO(Combination c) {
        this.id = c.getId();
        this.code = c.getCode();
        this.description = c.getDescription();
        this.sectionName = c.getSection().getName();
        this.courseNames = c.getMainCourses().stream()
                .map(Course::getName)
                .collect(Collectors.toSet());
    }
}

