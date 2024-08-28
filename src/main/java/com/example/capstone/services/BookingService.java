package com.example.capstone.services;

import java.util.List;
import com.example.capstone.model.Booking;

/**
 * Service interface for handling Booking operations.
 */
public interface BookingService {
    Booking createBooking(Booking booking);
    Booking getBookingById(Long id);
    List<Booking> getAllBookings();
    Booking updateBooking(Long id, Booking booking);
    void deleteBooking(Long id);
}