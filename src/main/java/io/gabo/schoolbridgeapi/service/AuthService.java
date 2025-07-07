package io.gabo.schoolbridgeapi.service;

import io.gabo.schoolbridgeapi.domain.UserRole;
import io.gabo.schoolbridgeapi.domain.User;
import io.gabo.schoolbridgeapi.dto.LoginResponseDTO;
import io.gabo.schoolbridgeapi.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthService {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public LoginResponseDTO authenticateUser(String username, String password) {
        System.out.println("Attempting login for: " + username);

        Optional<User> userOpt = userRepo.findByUserName(username)
                .or(() -> userRepo.findByEmail(username));

        if (userOpt.isEmpty()) {
            System.out.println("❌ User not found for: " + username);
            throw new RuntimeException("Invalid username or password.");
        }

        User user = userOpt.get();
        if (!encoder.matches(password, user.getPasswordHash())) {
            System.out.println("❌ Password mismatch for: " + username);
            throw new RuntimeException("Invalid username or password.");
        }

        System.out.println("✅ Authenticated user: " + user.getUserName());

        Set<String> activeRoles = user.getRoles().stream()
                .map(UserRole::getDbName)
                .collect(Collectors.toSet());

        String fullName = user.getFirstName() + " " + user.getFamilyName();
        String joinDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM yyyy"));

        return LoginResponseDTO.builder()
                .authToken(UUID.randomUUID().toString())
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
/*
@Serializable
data class LoginResponseDto(
        val authToken: String,
        val refreshToken: String,
        val userId: String,
        val email: String,
        val firstName: String,
        val lastName: String,
        val activeRoles: List<String>,

        val phoneNumber: String?,
        val nationalId: String?,
        val address: CurrentUser.Address?,
        val profilePictureUrl: String?,
        val role: String?,
        val joinDate: String?,
        val linkedStudents: List<CurrentUser.LinkedStudent>?,
        val gender: Gender?,
        val isVerified: Boolean
)
*/