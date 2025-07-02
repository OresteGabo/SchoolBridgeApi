package io.gabo.schoolbridgeapi.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginResponse {
    private String token;
    private String userName;
    private String message;

    public LoginResponse(String token, String userName, String message) {
        this.token = token;
        this.userName = userName;
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

