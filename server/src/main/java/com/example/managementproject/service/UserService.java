package com.example.managementproject.service;

import com.example.managementproject.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface UserService {
    ResponseEntity<?> registerUser(String username, String rawPassword);

    ResponseEntity<?> loginUser(String username, String password);

}
