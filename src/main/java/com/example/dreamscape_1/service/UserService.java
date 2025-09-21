package com.example.dreamscape_1.service;

import com.example.dreamscape_1.models.User;

import java.util.Optional;

public interface UserService {
    boolean registerUser(String fullName, String email, String password);
    boolean validateLogin(String email, String password);
}
