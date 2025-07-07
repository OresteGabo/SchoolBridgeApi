package io.gabo.schoolbridgeapi.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
