package com.example.capstone.repository;

import com.example.capstone.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing Booking data.
 */
//@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}