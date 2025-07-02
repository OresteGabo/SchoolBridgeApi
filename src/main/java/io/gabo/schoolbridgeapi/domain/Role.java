package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "roles")
@Data @NoArgsConstructor
class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String description;
    @Column(nullable = false, length = 15, unique = true)
    private String dbName;
}
