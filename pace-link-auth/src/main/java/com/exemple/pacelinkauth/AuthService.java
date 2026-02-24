package com.exemple.pacelinkauth;

import com.exemple.pacelinkauth.dto.LoginDTO;
import com.exemple.pacelinkauth.dto.RegisterDTO;
import com.exemple.pacelinkauth.exceptions.AuthException;
import com.exemple.pacelinkauth.model.User;
import com.exemple.pacelinkauth.security.JwtUtil;
import com.exemple.pacelinkauth.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthRepository repository;

    @Autowired
    private SecurityConfig securityConfig;

    @Autowired
    private JwtUtil jwtUtil;

    public Boolean register(RegisterDTO registerDTO) throws AuthException {
        try {
            User u = new User();
            u.setEmail(registerDTO.email);
            u.setUsername(registerDTO.username);
            u.setPassword(securityConfig.encodePassword(registerDTO.password));
            u.setRole(registerDTO.role);

            repository.save(u);
            return true;
        } catch (RuntimeException e){
            throw new AuthException(e.getMessage());
        }
    }

    public String login(LoginDTO loginDTO) throws AuthException {
        try {
            User u = repository.findByUsername(loginDTO.username);

            if(securityConfig.matches(loginDTO.password, u.getPassword()))
                return jwtUtil.generateToken(u.getUsername(), u.getRole());
            else throw new AuthException("Invalid username or password. Please try again.");
        } catch (RuntimeException e){
            throw new AuthException(e.getMessage());
        }
    }
}
