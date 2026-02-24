package com.exemple.pacelinkauth;

import com.exemple.pacelinkauth.dto.LoginDTO;
import com.exemple.pacelinkauth.dto.RegisterDTO;
import com.exemple.pacelinkauth.exceptions.AuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO registerDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.register(registerDTO));
        } catch (AuthException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.login(loginDTO));
        } catch (AuthException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
