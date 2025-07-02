package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity @Data @NoArgsConstructor
@Table(name = "users")
class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String familyName;
    @Column(nullable = false, length = 40)
    private String firstName;

    @Column(nullable = false, length = 40, unique = true)
    private String userName;
    @Column(nullable = false, length = 120)
    private String passwordHash;

    @Column(nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate dateOfBirth;
    @Column(length = 120, unique = true)
    private String email;

    private OffsetDateTime createdAt = OffsetDateTime.now();

    // Many‑to‑many link to Role via join table user_roles
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
}
