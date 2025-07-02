package io.gabo.schoolbridgeapi.dto;

public class SectionDTO {
    private Long id;
    private String name;
    private String degreeTypeName;

    public SectionDTO(Long id, String name, String degreeTypeName) {
        this.id = id;
        this.name = name;
        this.degreeTypeName = degreeTypeName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDegreeTypeName() {
        return degreeTypeName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDegreeTypeName(String degreeTypeName) {
        this.degreeTypeName = degreeTypeName;
    }
}

