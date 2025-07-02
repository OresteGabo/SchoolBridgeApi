package io.gabo.schoolbridgeapi.dto;

public class EducationLevelDTO {
    private Long id;
    private String name;
    private String degreeType;
    private String description;
    private Integer levelOrder;

    public EducationLevelDTO(Long id, String name, String degreeType, String description, Integer levelOrder) {
        this.id = id;
        this.name = name;
        this.degreeType = degreeType;
        this.description = description;
        this.levelOrder = levelOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevelOrder() {
        return levelOrder;
    }

    public void setLevelOrder(Integer levelOrder) {
        this.levelOrder = levelOrder;
    }
}
