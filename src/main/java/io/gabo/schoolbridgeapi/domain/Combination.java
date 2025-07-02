package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity(name = "combinations") @Data @NoArgsConstructor
class Combination {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, unique = true, length = 10) private String code; // e.g. "MCB"
    @Column(length = 120) private String description;

    @ManyToOne(optional = false) private Section section;

    @ManyToMany
    @JoinTable(name = "combination_courses",
            joinColumns = @JoinColumn(name = "combination_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> mainCourses = new HashSet<>();
}
