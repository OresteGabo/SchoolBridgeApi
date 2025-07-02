package io.gabo.schoolbridgeapi.domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
@Entity(name = "sectors") @Data @NoArgsConstructor
public class Sector {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25)
    private String name;

    @ManyToOne(optional = false)
    private District district;
}
