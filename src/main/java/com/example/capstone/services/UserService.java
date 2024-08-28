package com.example.capstone.services;


import com.example.capstone.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    User saveUser(User user);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    Optional<User> getUserByUsername(String username);

    User updateUser(Long id, User updatedUser);

    void deleteUser(Long id);

    Iterable<User> getAllUsers();
}