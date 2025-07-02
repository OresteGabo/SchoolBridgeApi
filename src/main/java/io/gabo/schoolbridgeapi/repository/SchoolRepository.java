package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    // Add custom queries if needed
}

