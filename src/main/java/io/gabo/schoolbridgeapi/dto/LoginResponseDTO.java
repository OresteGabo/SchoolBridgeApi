package io.gabo.schoolbridgeapi.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LoginResponseDTO {

    private String authToken;
    private String refreshToken;
    private String userId;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String nationalId;
    private String gender;
    private boolean isVerified;
    private String role; // main/primary role
    private List<String> activeRoles;
    private String joinDate;
    private Address address;
    private List<LinkedStudent> linkedStudents;

    @Data
    @Builder
    public static class Address {
        private String district;
        private String sector;
        private String cell;
        private String village;
    }

    @Data
    @Builder
    public static class LinkedStudent {
        private String id;
        private String firstName;
        private String lastName;
    }
}
