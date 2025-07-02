package io.gabo.schoolbridgeapi.domain;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity(name = "sectors") @NoArgsConstructor
public class Sector {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 25)
    private String name;

    @ManyToOne(optional = false)
    private District district;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}
