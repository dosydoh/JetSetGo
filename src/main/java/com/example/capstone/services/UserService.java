package com.example.capstone.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.example.capstone.model.User;
import com.example.capstone.repository.UserRegistration;

public interface UserService extends UserDetailsService {
    User findByEmail(String email);
    User save(UserRegistration registration);
}
