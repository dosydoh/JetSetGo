package com.example.capstone.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

/**
 * Entity class representing a role assigned to a user.
 */
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;

    @Override
    public String getAuthority() {
        return roleName;
    }

    // Getters and setters
}