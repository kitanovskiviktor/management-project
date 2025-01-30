package com.example.managementproject.service.impl;

import com.example.managementproject.model.User;
import com.example.managementproject.repository.UserRepository;
import com.example.managementproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public ResponseEntity<?> registerUser(String username, String password) {
        if(userRepository.existsByUsername(username)){
            return ResponseEntity
                    .badRequest()
                    .body("Username is already taken");
        }
        User user = new User();
        user.setUsername(username);
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);

        return ResponseEntity.ok(userRepository.save(user));
    }

    @Override
    public ResponseEntity<?> loginUser(String username, String password) {

        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("User not found");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid password");
        }
        return ResponseEntity.ok(user);
    }
}
