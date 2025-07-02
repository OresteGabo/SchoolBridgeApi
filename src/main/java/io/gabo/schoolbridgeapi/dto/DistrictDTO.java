package io.gabo.schoolbridgeapi.dto;

public class DistrictDTO {
    private Long id;
    private String name;
    private int sectorCount;

    public DistrictDTO(Long id, String name, int sectorCount) {
        this.id = id;
        this.name = name;
        this.sectorCount = sectorCount;
    }
}
