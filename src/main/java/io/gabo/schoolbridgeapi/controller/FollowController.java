// FollowController.java
package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.School;
import io.gabo.schoolbridgeapi.domain.User;
import io.gabo.schoolbridgeapi.domain.UserSchoolFollow;
import io.gabo.schoolbridgeapi.dto.FollowRequestDTO;
import io.gabo.schoolbridgeapi.dto.FollowedSchoolDTO;
import io.gabo.schoolbridgeapi.repository.SchoolRepository;
import io.gabo.schoolbridgeapi.repository.UserRepository;
import io.gabo.schoolbridgeapi.repository.UserSchoolFollowRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/follows")
public class FollowController {

    private final UserRepository userRepository;
    private final SchoolRepository schoolRepository;
    private final UserSchoolFollowRepository followRepository;

    public FollowController(UserRepository userRepository,
                            SchoolRepository schoolRepository,
                            UserSchoolFollowRepository followRepository) {
        this.userRepository = userRepository;
        this.schoolRepository = schoolRepository;
        this.followRepository = followRepository;
    }

    @PostMapping
    public ResponseEntity<String> followSchool(@RequestBody FollowRequestDTO request) {
        User user = userRepository.findById(request.getUserId()).orElse(null);
        School school = schoolRepository.findById(request.getSchoolId()).orElse(null);
        if (user == null || school == null) {
            return ResponseEntity.badRequest().body("Invalid user or school ID");
        }

        if (!followRepository.existsByUserAndSchool(user, school)) {
            followRepository.save(new UserSchoolFollow(user, school));
        }

        return ResponseEntity.ok("Followed successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> unfollowSchool(@RequestBody FollowRequestDTO request) {
        User user = userRepository.findById(request.getUserId()).orElse(null);
        School school = schoolRepository.findById(request.getSchoolId()).orElse(null);
        if (user == null || school == null) {
            return ResponseEntity.badRequest().body("Invalid user or school ID");
        }

        followRepository.findByUserAndSchool(user, school).ifPresent(followRepository::delete);
        return ResponseEntity.ok("Unfollowed successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<FollowedSchoolDTO>> getFollowedSchools(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    List<FollowedSchoolDTO> list = followRepository.findByUser(user).stream()
                            .map(f -> new FollowedSchoolDTO(f.getSchool().getId(), f.getSchool().getName()))
                            .collect(Collectors.toList());
                    return ResponseEntity.ok(list);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
