package io.gabo.schoolbridgeapi.dto;

import io.gabo.schoolbridgeapi.domain.School;

public class SchoolDTO {
    private Long id;
    private String name;
    private String abbrevName;
    private String logoUrl;
    private String contactPhone;
    private String contactEmail;
    private String websiteUrl;

    private String districtName;
    private String sectorName;

    public SchoolDTO(School school) {
        this.id = school.getId();
        this.name = school.getName();
        this.abbrevName = school.getAbbrevName();
        this.logoUrl = school.getLogoUrl();
        this.contactPhone = school.getContactPhone();
        this.contactEmail = school.getContactEmail();
        this.websiteUrl = school.getWebsiteUrl();
        this.districtName = school.getDistrict().getName();
        this.sectorName = school.getSector().getName();
    }
}

