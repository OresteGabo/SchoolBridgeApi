package io.gabo.schoolbridgeapi.service;

import io.gabo.schoolbridgeapi.domain.UserRole;
import io.gabo.schoolbridgeapi.domain.User;
import io.gabo.schoolbridgeapi.dto.LoginResponseDTO;
import io.gabo.schoolbridgeapi.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    private final JWTService jwtService;

    public AuthService(UserRepository userRepo, JWTService jwtService) {
        this.userRepo = userRepo;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO authenticateUser(String username, String password) throws NoSuchAlgorithmException {
        System.out.println("Attempting login for: " + username);

        Optional<User> userOpt = userRepo.findByUsername(username)
                .or(() -> userRepo.findByEmail(username));
        System.out.println("user opt = "+userOpt);
        if (userOpt.isEmpty()) {
            System.out.println("❌ User not found for: " + username);
            throw new RuntimeException("Invalid username or password.");
        }

        User user = userOpt.get();
        if (!encoder.matches(password, user.getPassword())) {
            System.out.println("❌ Password mismatch for: " + username);
            throw new RuntimeException("Invalid username or password.");
        }

        System.out.println("✅ Authenticated user: " + user.getUsername());

        Set<String> activeRoles = user.getRoles().stream()
                .map(UserRole::getDbName)
                .collect(Collectors.toSet());

        //String fullName = user.getFirstName() + " " + user.getFamilyName();
        String joinDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM yyyy"));

        return LoginResponseDTO.builder()
                .authToken(jwtService.generateToken(user.getUsername()))
                .refreshToken(UUID.randomUUID().toString())
                .userId("usr_" + user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getFamilyName())
                .phoneNumber(user.getPhoneNumber()==null?"UNKNOWN":user.getPhoneNumber())
                .nationalId(user.getNationalId()==null?"UNKNOWN":user.getNationalId())
                .gender(user.getGender() != null ? user.getGender().toString() : "UNKNOWN")
                .activeRoles(new ArrayList<>(activeRoles))
                .role(activeRoles.stream().findFirst().orElse("GUEST"))
                .joinDate(joinDate)
                .linkedStudents(Collections.emptyList()) // TODO: load real linked students
                .isVerified(true)
                .build();
    }
}