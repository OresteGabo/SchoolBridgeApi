package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "degree_types")
@Data
@NoArgsConstructor
public class DegreeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String name;  // e.g. "A1", "A0", "Masters", "PhD"

    @Column(length = 120)
    private String description;
}