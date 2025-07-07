// UserSchoolFollowRepository.java
package io.gabo.schoolbridgeapi.repository;

import io.gabo.schoolbridgeapi.domain.User;
import io.gabo.schoolbridgeapi.domain.School;
import io.gabo.schoolbridgeapi.domain.UserSchoolFollow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserSchoolFollowRepository extends JpaRepository<UserSchoolFollow, Long> {
    boolean existsByUserAndSchool(User user, School school);
    Optional<UserSchoolFollow> findByUserAndSchool(User user, School school);
    List<UserSchoolFollow> findByUser(User user);
}
