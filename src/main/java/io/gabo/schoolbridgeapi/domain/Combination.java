package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "combinations")
@Data @NoArgsConstructor
class Combination {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 10)
    private String code;  // e.g., "MCB", "HEG"

    @Column(length = 100)
    private String description; // optional: "Math-Chemistry-Biology"

    @ManyToOne(optional = false)
    private Section section; // e.g., Science, Arts
}

