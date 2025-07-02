package io.gabo.schoolbridgeapi.dto;

public class SectorDTO {
    private Long id;
    private String name;
    private String districtName;

    public SectorDTO(Long id, String name, String districtName) {
        this.id = id;
        this.name = name;
        this.districtName = districtName;
    }
}
