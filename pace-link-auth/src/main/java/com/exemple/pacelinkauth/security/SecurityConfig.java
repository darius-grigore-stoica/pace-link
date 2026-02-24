package com.exemple.pacelinkauth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public String encodePassword(String password) {
        return passwordEncoder().encode(password);
    }
    public boolean matches(String p1, String p2){
        return passwordEncoder().matches(p1, p2);
    }
}
