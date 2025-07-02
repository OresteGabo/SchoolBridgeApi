package io.gabo.schoolbridgeapi.domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity @Data @NoArgsConstructor
class VerificationType {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50, unique = true)
    private String label;
}

