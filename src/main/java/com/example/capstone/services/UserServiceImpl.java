package com.example.capstone.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Arrays;
import com.example.capstone.model.User;
import com.example.capstone.model.Role;
import com.example.capstone.repository.UserRegistration;
import com.example.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
//import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User save(UserRegistration registration){
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        //user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                //mapRolesToAuthorities(user.getRoles()));
                new ArrayList<>());
    }

//    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toList());
    }

