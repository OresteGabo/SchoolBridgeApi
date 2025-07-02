package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.domain.User;
import io.gabo.schoolbridgeapi.dto.LoginRequest;
import io.gabo.schoolbridgeapi.dto.LoginResponse;
import io.gabo.schoolbridgeapi.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserRepository userRepository;

    // For demo purposes; in real app, you’d inject authService and password encoder
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // Find user by username or email
        Optional<User> userOpt = userRepository.findByUserName(loginRequest.getUserNameOrEmail());
        if (userOpt.isEmpty()) {
            userOpt = userRepository.findByEmail(loginRequest.getUserNameOrEmail());
        }
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(401).body(new LoginResponse(null, null, "User not found"));
        }

        User user = userOpt.get();
        // TODO: Replace with real password hash verification (e.g., BCrypt)
        if (!user.getPasswordHash().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(401).body(new LoginResponse(null, null, "Invalid password"));
        }

        // Generate token (stub)
        String token = "dummy-token-for-user-" + user.getUserName();

        return ResponseEntity.ok(new LoginResponse(token, user.getUserName(), "Login successful"));
    }

    // You can add CRUD endpoints for User here if needed
}
