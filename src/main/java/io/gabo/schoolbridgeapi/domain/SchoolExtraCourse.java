package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "school_extra_courses")
@Data
@NoArgsConstructor
class SchoolExtraCourse {
    @EmbeddedId
    private SchoolExtraCourseKey id;

    @ManyToOne(optional = false) @MapsId("schoolLevelOfferingId")
    private SchoolLevelOffering offering;
    @ManyToOne(optional = false) @MapsId("courseId")
    private Course course;
}
