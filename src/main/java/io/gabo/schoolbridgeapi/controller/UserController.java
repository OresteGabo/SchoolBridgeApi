package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.dto.LoginRequestDTO;
import io.gabo.schoolbridgeapi.dto.LoginResponseDTO;
import io.gabo.schoolbridgeapi.dto.UserInfoDTO;
import io.gabo.schoolbridgeapi.service.AuthService;
import io.gabo.schoolbridgeapi.repository.UserRepository;
import io.gabo.schoolbridgeapi.domain.UserRole;
import io.gabo.schoolbridgeapi.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserRepository userRepo;
    private final AuthService    authService;

    public UserController(UserRepository userRepo, AuthService authService) {
        this.userRepo    = userRepo;
        this.authService = authService;
    }

    /* ---------- LOGIN ---------- */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO req) {

        System.out.println("--------------------------------------------------");
        System.out.println("🕒 [" + LocalDateTime.now() + "]  LOGIN attempt");
        System.out.println("   ↳ username/email : " + req.getUsername());
        System.out.println("   ↳ raw password   : " + req.getPassword());
        System.out.println("--------------------------------------------------");

        try {
            LoginResponseDTO response =
                    authService.authenticateUser(req.getUsername(), req.getPassword());

            System.out.println(response);
            System.out.println("--------------------------------------------------\n");
            return ResponseEntity.ok(response);

        } catch (RuntimeException ex) {

            System.out.println("❌ LOGIN failed for " + req.getUsername()
                    + "  –  reason: " + ex.getMessage());
            System.out.println("--------------------------------------------------\n");
            return ResponseEntity.status(401).body(Map.of("error", ex.getMessage()));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /* ---------- CURRENT USER INFO ---------- */
    @GetMapping("/me")
    public ResponseEntity<UserInfoDTO> me(Principal principal) {

        System.out.println("--------------------------------------------------");
        System.out.println("🕒 [" + LocalDateTime.now() + "]  /me requested by token subject: "
                + principal.getName());

        Optional<User> userOpt = userRepo.findByUsername(principal.getName());

        if (userOpt.isEmpty()) {
            System.out.println("⚠️  /me – user not found: " + principal.getName());
            System.out.println("--------------------------------------------------\n");
            return ResponseEntity.notFound().build();
        }

        User u = userOpt.get();
        Set<String> roles = u.getRoles().stream()
                .map(UserRole::getDbName)
                .collect(Collectors.toSet());

        System.out.println("✅ /me – found user: " + u.getUsername()
                + "  (id=" + u.getId() + ")");
        System.out.println("   ↳ Roles: " + roles);
        System.out.println("--------------------------------------------------\n");

        UserInfoDTO dto = new UserInfoDTO(
                u.getId(),
                u.getUsername(),
                u.getEmail(),
                u.getFirstName() + " " + u.getFamilyName(),
                roles
        );
        return ResponseEntity.ok(dto);
    }
}
