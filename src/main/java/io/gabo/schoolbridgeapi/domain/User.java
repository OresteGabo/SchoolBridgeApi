package io.gabo.schoolbridgeapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity @NoArgsConstructor
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String familyName;
    @Column(nullable = false, length = 40)
    private String firstName;

    @Column(nullable = true, length = 15)
    private String phoneNumber;

    @Column(nullable = true, length = 20)
    private String nationalId;

    @Column(nullable = false, length = 40, unique = true)
    private String username;
    @Column(nullable = false, length = 120)
    private String password;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dateOfBirth;
    @Column(length = 120, unique = true)
    private String email;

    private OffsetDateTime createdAt = OffsetDateTime.now();

    public Boolean hasRole(UserRole role) {
        return roles.contains(role);
    }
    public Boolean hasRole(String role) {
        for (UserRole userRole : roles) {
            if( userRole.getDbName().equals(role) )
                return true;
        }
        return false;
    }

    // Many‑to‑many link to Role via join table user_roles
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonIgnore
    private Set<UserRole> roles = new HashSet<>();

    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<StudentEnrollment> enrollments = new HashSet<>();

    @JsonIgnore     // prevents endless JSON recursion
    public Optional<StudentEnrollment> getCurrentEnrollment() {
        return enrollments.stream().filter(StudentEnrollment::isCurrent).findFirst();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passwordHash) {
        this.password = passwordHash;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
    public Set<StudentEnrollment> getEnrollments() {
        return enrollments;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public void setEnrollments(Set<StudentEnrollment> enrollments) {
        this.enrollments = enrollments;
    }
}
