package io.gabo.schoolbridgeapi.dto;

public class UserDTO {
    private Long id;
    private String userName;
    private String firstName;
    private String familyName;
    private String email;

    public UserDTO(Long id, String userName, String firstName, String familyName, String email) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.familyName = familyName;
        this.email = email;
    }
}

