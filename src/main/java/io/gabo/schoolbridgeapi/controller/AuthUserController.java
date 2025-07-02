package io.gabo.schoolbridgeapi.controller;

import io.gabo.schoolbridgeapi.model.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        String username = request.username();
        String password = request.password();

        if ("admin".equals(username) && "1234".equals(password)) {
            return "Welcome, " + username;
        } else {
            return "Invalid credentials";
        }
    }
}
