package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.Combination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CombinationRepository extends JpaRepository<Combination, Long> {
    Optional<Combination> findByCodeIgnoreCase(String code);
}

