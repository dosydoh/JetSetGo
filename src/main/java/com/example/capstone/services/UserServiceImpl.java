package com.example.capstone.services;


import com.example.capstone.model.User;
import com.example.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Ensure the password is encoded
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(updatedUser.getFirstName());
                    user.setLastName(updatedUser.getLastName());
                    user.setEmail(updatedUser.getEmail());
                    if (!updatedUser.getPassword().equals(user.getPassword())) {
                        user.setPassword(passwordEncoder.encode(updatedUser.getPassword())); // Ensure this is encoded
                    }
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return user;
    }
}

/////SECOND DRAFT ///////////


//import com.example.capstone.repository.UserRepository;
//import com.example.capstone.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import java.util.Optional;
////import java.util.List;
//
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public UserServiceImpl(UserRepository userRepository) {
//        super(userRepository);
//    }
//
//    @Override
//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public Optional<User> getUserById(Long id) {
//        return userRepository.findById(id);
//    }
//
//    @Override
//    public Optional<User> getUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    @Override
//    public Optional<User> getUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    @Override
//    public User updateUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//    }
//}




////FIRST DRAFT  //////

///**
// * Service implementation for handling User operations.
// */
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public User registerUser(UserRegistrationDto userRegistrationDto) {
//        User user = new User();
//        user.setFirstName(userRegistrationDto.getFirstName());
//        user.setLastName(userRegistrationDto.getLastName());
//        user.setEmail(userRegistrationDto.getEmail());
//        user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
//        return userRepository.save(user);
//    }
//
//    @Override
//    public User getUserById(Long id) {
//        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public User updateUser(Long id, User user) {
//        if (!userRepository.existsById(id)) {
//            throw new ResourceNotFoundException("User not found with id " + id);
//        }
//        user.setId(id);
//        return userRepository.save(user);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        if (!userRepository.existsById(id)) {
//            throw new ResourceNotFoundException("User not found with id " + id);
//        }
//        userRepository.deleteById(id);
//    }
//}