package io.gabo.schoolbridgeapi.dto;

public class DistrictDTO {
    private Long id;
    private String name;
    private int sectorCount;

    public DistrictDTO() {}

    public DistrictDTO(Long id, String name, int sectorCount) {
        this.id = id;
        this.name = name;
        this.sectorCount = sectorCount;
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

    public int getSectorCount() {
        return sectorCount;
    }
    public void setSectorCount(int sectorCount) {
        this.sectorCount = sectorCount;
    }
}
