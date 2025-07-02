package io.gabo.schoolbridgeapi.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "bank_accounts") @Data @NoArgsConstructor
class BankAccount {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private School accountOwner;

    @ManyToOne(optional = false)
    private Bank bank;

    @Column(nullable = false, length = 50, unique = true)
    private String accountNumber;
}
