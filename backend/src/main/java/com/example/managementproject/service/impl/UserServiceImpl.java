package com.example.managementproject.service.impl;

import com.example.managementproject.model.User;
import com.example.managementproject.repository.UserRepository;
import com.example.managementproject.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
   // private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
      //  this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User registerUser(String username, String password) {
        User user = new User();
        user.setUsername(username);

       // String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(password);

        return userRepository.save(user);
    }
}
