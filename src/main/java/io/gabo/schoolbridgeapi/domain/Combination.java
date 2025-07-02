package io.gabo.schoolbridgeapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity(name = "combinations")  @NoArgsConstructor
public class Combination {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false, unique = true, length = 10) private String code; // e.g. "MCB"
    @Column(length = 120) private String description;

    @ManyToOne(optional = false) private Section section;

    @ManyToMany
    @JoinTable(name = "combination_courses",
            joinColumns = @JoinColumn(name = "combination_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonIgnore
    private Set<Course> mainCourses = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<Course> getMainCourses() {
        return mainCourses;
    }

    public void setMainCourses(Set<Course> mainCourses) {
        this.mainCourses = mainCourses;
    }
}
