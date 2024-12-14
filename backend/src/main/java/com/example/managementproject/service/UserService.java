package com.example.managementproject.service;

import com.example.managementproject.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User registerUser(String username, String rawPassword);

}
