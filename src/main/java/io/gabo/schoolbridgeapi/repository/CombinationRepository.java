package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.Combination;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CombinationRepository extends JpaRepository<Combination, Long> {

    @EntityGraph(attributePaths = {"section.educationLevel.degreeType", "mainCourses"})
    List<Combination> findAll();

    @EntityGraph(attributePaths = {"section.educationLevel.degreeType", "mainCourses"})
    Optional<Combination> findById(Long id);

    @EntityGraph(attributePaths = {"section.educationLevel.degreeType", "mainCourses"})
    Optional<Combination> findByCodeIgnoreCase(String code);
}


