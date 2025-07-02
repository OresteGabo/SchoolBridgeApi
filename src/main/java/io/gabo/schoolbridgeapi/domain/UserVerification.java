package io.gabo.schoolbridgeapi.domain;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity @Data @NoArgsConstructor
class UserVerification {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private VerificationType verificationType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "verified_user_id")
    private User verifiedUser;

    @ManyToOne(optional = false)
    @JoinColumn(name = "verifying_in_charge_user_id")
    private User verifyingInCharge;

    private OffsetDateTime date;
}
