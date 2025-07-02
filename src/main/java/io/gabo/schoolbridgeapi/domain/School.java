package io.gabo.schoolbridgeapi.domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "schools") @Data @NoArgsConstructor
class School {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100) private String name;
    @Column(length = 25) private String abbrevName;
    private String logoUrl;
    @Column(nullable = false) private boolean hasBoarding;
    @Column(length = 15) private String contactPhone;
    @Column(length = 50) private String contactEmail;
    @Column(length = 100) private String websiteUrl;

    @ManyToOne(optional = false) private District district;
    @ManyToOne(optional = false) private Sector sector;

    @OneToMany(mappedBy = "school")
    private Set<SchoolEducationLevel> levelLinks = new HashSet<>();
}