package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;



@Entity (name ="courses") @Data @NoArgsConstructor
class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, length = 50, unique = true) private String name;
    @Column(length = 250) private String description;

    // reverse link for clarity
    @ManyToMany(mappedBy = "mainCourses") private Set<Combination> combinations = new HashSet<>();
}