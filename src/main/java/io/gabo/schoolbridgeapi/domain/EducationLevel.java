package io.gabo.schoolbridgeapi.domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "education_levels")
@Data
@NoArgsConstructor
public class EducationLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private DegreeType degreeType;  // replaces the 'name' field

    @Column(length = 120)
    private String description;

    @Column(nullable = false)
    private Integer levelOrder; // e.g., for sorting progression
}

