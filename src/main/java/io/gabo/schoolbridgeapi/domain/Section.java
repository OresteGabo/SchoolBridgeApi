package io.gabo.schoolbridgeapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity(name = "sections")  @NoArgsConstructor
public class Section {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, length = 50) private String name;  // Science, Arts, Commerce

    @ManyToOne(optional = false) private EducationLevel educationLevel;

    @OneToMany(mappedBy = "section")
    @JsonIgnore
    private Set<Combination> combinations = new HashSet<>();


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Set<Combination> getCombinations() {
        return combinations;
    }

    public void setCombinations(Set<Combination> combinations) {
        this.combinations = combinations;
    }
}