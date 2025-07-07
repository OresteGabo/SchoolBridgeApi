package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findByDbNameIgnoreCase(String dbName);
}
