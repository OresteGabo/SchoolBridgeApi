package io.gabo.schoolbridgeapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // ✅ CSRF disabled (for mobile APIs)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/login").permitAll() // ✅ Allow unauthenticated access
                        .anyRequest().authenticated()                // 🔐 Secure everything else
                )
                .httpBasic(Customizer.withDefaults()); // Optional (enables browser login test)

        return http.build();
    }
}
