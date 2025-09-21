package com.example.dreamscape_1.service.impl;

import com.example.dreamscape_1.models.User;

import com.example.dreamscape_1.repository.UserRepository;
import com.example.dreamscape_1.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(String fullName, String email, String password) {
        try {
            System.out.println("=== REGISTER USER DEBUG ===");
            System.out.println("Input: " + fullName + ", " + email);

            // Test basic repository functionality
            System.out.println("Testing repository...");
            long userCount = userRepository.count();
            System.out.println("Total users in database: " + userCount);

            // List all existing users for debugging
            System.out.println("All existing users:");
            userRepository.findAll().forEach(user ->
                    System.out.println("  - " + user.getEmail() + " (" + user.getFullName() + ")")
            );

            // Test the existsByEmail method
            System.out.println("Testing existsByEmail for: " + email);
            boolean emailExists = userRepository.existsByEmail(email);
            System.out.println("Email exists result: " + emailExists);

            if (emailExists) {
                System.out.println("Email already registered: " + email);
                return false;
            }

            System.out.println("Creating new user...");
            String hash = passwordEncoder.encode(password);
            User user = new User(fullName, email, hash);
            User savedUser = userRepository.save(user);
            System.out.println("User saved successfully with ID: " + savedUser.getId());
            return true;

        } catch (Exception e) {
            System.out.println("ERROR in registerUser: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean validateLogin(String email, String password) {
        return userRepository.findByEmail(email)
                .map(user -> passwordEncoder.matches(password, user.getPasswordHash()))
                .orElse(false);
    }
}


