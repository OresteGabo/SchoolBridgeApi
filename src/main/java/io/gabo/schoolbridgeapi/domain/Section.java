package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity(name = "sections")
class Section {
    @Id
    @GeneratedValue
    Long id;

    @Column
    String name;  // e.g., Science, Arts, Commerce

    @ManyToOne(optional = false)
    SchoolLevel schoolLevel;
}

/*

@Entity @Data
@NoArgsConstructor
class Section {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, length = 50) private String name;  // Science, Arts, Commerce

    @ManyToOne(optional = false) private EducationLevel educationLevel;

    @OneToMany(mappedBy = "section")
    private Set<Combination> combinations = new HashSet<>();
}
*/