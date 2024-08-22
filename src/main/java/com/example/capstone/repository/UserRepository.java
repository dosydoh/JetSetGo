package com.example.capstone.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<email, Long> {
    findByEmail(String email);

}
