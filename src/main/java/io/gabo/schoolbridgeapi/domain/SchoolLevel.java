package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity(name = "school_levels")        // table = school_levels
@Data @NoArgsConstructor
class SchoolLevel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25, unique = true)
    private String name;         // e.g. "TVET", "O_LEVEL"

    @Column(nullable = false, length = 120)
    private String description;  // human‑friendly text

    @Column(nullable = false, length = 50)
    String degreeType;  // e.g. "O Level", "A Level", "Diploma"
}

/*
@Entity(name = "school_levels")        // table = school_levels
@Data @NoArgsConstructor
class SchoolLevel {
    @Id @GeneratedValue
    Long id;

    @Column(nullable = false, unique = true)
    String name;  // e.g. "O_LEVEL", "A_LEVEL", "TVET"

    @Column(nullable = false, length = 50)
    String degreeType;  // e.g. "O Level", "A Level", "Diploma"

    @Column(length = 120)
    String description;

    @OneToMany(mappedBy = "schoolLevel")
    Set<Section> sections;
}
*/


