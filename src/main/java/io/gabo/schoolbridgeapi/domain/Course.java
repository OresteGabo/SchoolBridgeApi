package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;



@Entity (name ="courses")  @NoArgsConstructor
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, length = 50, unique = true) private String name;
    @Column(length = 250) private String description;

    // reverse link for clarity
    @ManyToMany(mappedBy = "mainCourses") private Set<Combination> combinations = new HashSet<>();

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Combination> getCombinations() {
        return combinations;
    }

    public void setCombinations(Set<Combination> combinations) {
        this.combinations = combinations;
    }
}