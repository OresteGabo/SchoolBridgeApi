package io.gabo.schoolbridgeapi.domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "education_levels") @Data @NoArgsConstructor
class EducationLevel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25)
    private String name;
    @Column(nullable = false, length = 120)
    private String description;
    @Column(nullable = false)
    private Integer levelOrder;
}
