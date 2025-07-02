package io.gabo.schoolbridgeapi.domain;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

import lombok.NoArgsConstructor;


@Entity(name = "schools") @NoArgsConstructor
public class School {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100) private String name;
    @Column(length = 25) private String abbrevName;
    private String logoUrl;
    @Column(nullable = false) private boolean hasBoarding;
    @Column(length = 15) private String contactPhone;
    @Column(length = 50) private String contactEmail;
    @Column(length = 100) private String websiteUrl;

    @ManyToOne(optional = false) private District district;
    @ManyToOne(optional = false) private Sector sector;

    @OneToMany(mappedBy = "school")
    private Set<SchoolEducationLevel> levelLinks = new HashSet<>();


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

    public boolean isHasBoarding() {
        return hasBoarding;
    }

    public void setHasBoarding(boolean hasBoarding) {
        this.hasBoarding = hasBoarding;
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Set<SchoolEducationLevel> getLevelLinks() {
        return levelLinks;
    }

    public void setLevelLinks(Set<SchoolEducationLevel> levelLinks) {
        this.levelLinks = levelLinks;
    }
}