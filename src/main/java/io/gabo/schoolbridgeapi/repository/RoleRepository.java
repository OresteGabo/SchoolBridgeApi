package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByDbNameIgnoreCase(String dbName);
}
