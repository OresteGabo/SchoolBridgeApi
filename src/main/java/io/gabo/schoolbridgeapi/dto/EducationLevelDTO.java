package io.gabo.schoolbridgeapi.dto;

public class EducationLevelDTO {

    private Long id;
    private Long degreeTypeId;     // incoming/outgoing id
    private String degreeTypeName; // outgoing label (read‑only)
    private String description;
    private Integer levelOrder;

    /*–– constructors ––*/
    public EducationLevelDTO() {}  // ← required by Jackson

    public EducationLevelDTO(Long id,
                             Long degreeTypeId,
                             String degreeTypeName,
                             String description,
                             Integer levelOrder) {
        this.id = id;
        this.degreeTypeId = degreeTypeId;
        this.degreeTypeName = degreeTypeName;
        this.description = description;
        this.levelOrder = levelOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDegreeTypeId() {
        return degreeTypeId;
    }

    public void setDegreeTypeId(Long degreeTypeId) {
        this.degreeTypeId = degreeTypeId;
    }

    public String getDegreeTypeName() {
        return degreeTypeName;
    }

    public void setDegreeTypeName(String degreeTypeName) {
        this.degreeTypeName = degreeTypeName;
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
