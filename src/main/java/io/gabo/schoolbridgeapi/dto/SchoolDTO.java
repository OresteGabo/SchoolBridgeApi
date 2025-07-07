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

    public SchoolDTO() {} // for deserialization

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

    public String getAbbrevName() {
        return abbrevName;
    }

    public void setAbbrevName(String abbrevName) {
        this.abbrevName = abbrevName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }
}
