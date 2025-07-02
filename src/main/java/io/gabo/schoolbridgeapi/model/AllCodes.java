package io.gabo.schoolbridgeapi.model;


import jakarta.persistence.*;
import java.util.Objects;
/*
@Entity
@Table(name = "auth_user")
public class AuthUser {

    @Id
    @Column(length = 50)
    private String id;

    @Column(nullable = false)
    private String password;

    @Column(name = "family_name", nullable = false, length = 100)
    private String familyName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    // No-arg constructor required by JPA
    protected AuthUser() {}

    public AuthUser(String id, String password, String familyName, String lastName, String phoneNumber) {
        this.id = id;
        this.password = password;
        this.familyName = familyName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters (or just getters if you want immutable but JPA prefers setters)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // equals and hashCode based on id

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthUser)) return false;
        AuthUser authUser = (AuthUser) o;
        return Objects.equals(getId(), authUser.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // toString (avoid printing password)
    @Override
    public String toString() {
        return "AuthUser{" +
                "id='" + id + '\'' +
                ", familyName='" + familyName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

*/
/*
* @Entity
@Table(name = "districts")
public class District {

    @Id
    @Column(length = 2, nullable = false, updatable = false)
    private String id;

    @Column(nullable = false, length = 10, unique = true)
    private String name;

    protected District() {} // JPA

    public District(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }

}
* */

/*
* package io.gabo.schoolbridgeapi.model;

import jakarta.persistence.*;

/**
 * Sector belongs to exactly one District.
 * Its primary key is a 4‑character string: districtId (2) + localId (2).
 *
 * Example: district "01", local "A2" → sector.id = "01A2".
 *
@Entity
@Table(
        name = "sectors",
        uniqueConstraints = @UniqueConstraint(columnNames = {"district_id", "local_id"})
)
public class Sector {

    /** Full 4‑char ID (PK). *
    @Id
    @Column(length = 4, nullable = false, updatable = false)
    private String id;

    /** Human‑readable name of the sector. *
    @Column(nullable = false,length = 15)
    private String name;

    /** Two‑character local ID inside the district ("A1", "B0" …). *
    @Column(length = 2, name = "local_id", nullable = false, updatable = false)
    private String localId;

    /** Owning District (FK). *
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "district_id", nullable = false, updatable = false)
    private District district;

    /* --- constructors --------------------------------------------------- *

    protected Sector() {}   // required by JPA

    /**
     * @param district   parent district entity (must be managed or cascaded)
     * @param localId    two‑char local ID
     * @param name       sector name
     *
    public Sector(District district, String localId, String name) {
        this.district = district;
        this.localId  = localId;
        this.name     = name;
        this.id       = district.getId() + localId;  // e.g. "01" + "A2" = "01A2"
    }

    /* --- getters -------------------------------------------------------- *

    public String getId()        { return id; }
    public String getName()      { return name; }
    public String getLocalId()   { return localId; }
    public District getDistrict(){ return district; }

    /* equals & hashCode solely on id *
    @Override public boolean equals(Object o) {
        return o instanceof Sector s && id.equals(s.id);
    }
    @Override public int hashCode() { return id.hashCode(); }
}


* */