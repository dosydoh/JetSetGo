package com.example.capstone.repository;

import com.example.capstone.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing Destination data.
 */
//@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {
}