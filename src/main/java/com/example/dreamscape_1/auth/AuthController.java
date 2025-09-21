package com.example.dreamscape_1.auth;

import com.example.dreamscape_1.auth.dto.AuthResponse;
import com.example.dreamscape_1.auth.dto.LoginRequest;
import com.example.dreamscape_1.auth.dto.RegisterRequest;
import com.example.dreamscape_1.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"*"}, allowCredentials = "false")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        System.out.println("Register request received: " + request.getFullName() + ", " + request.getEmail());
        System.out.println("Register request received: " + request.getFullName() + ", " + request.getEmail());
        boolean ok = userService.registerUser(request.getFullName(), request.getEmail(), request.getPassword());
        if (!ok) {
            return ResponseEntity.status(409).body(new AuthResponse(false, "Email already registered"));
        }
        return ResponseEntity.ok(new AuthResponse(true, "Registered successfully"));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        boolean ok = userService.validateLogin(request.getEmail(), request.getPassword());
        if (!ok) {
            return ResponseEntity.status(401).body(new AuthResponse(false, "Invalid email or password"));
        }
        return ResponseEntity.ok(new AuthResponse(true, "Login successful"));
    }
}


