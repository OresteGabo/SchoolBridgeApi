package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@Entity(name = "degree_types")
@NoArgsConstructor
public class DegreeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;  // e.g. "A1", "A0", "Masters", "PhD"

    @Column(length = 120)
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}