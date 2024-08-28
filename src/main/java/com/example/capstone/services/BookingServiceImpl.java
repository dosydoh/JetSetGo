package com.example.capstone.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.capstone.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.capstone.model.Booking;
import com.example.capstone.repository.BookingRepository;

/**
 * Service implementation for handling Booking operations.
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + id));
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        if (!bookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Booking not found with id " + id);
        }
        booking.setId(id);
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Booking not found with id " + id);
        }
        bookingRepository.deleteById(id);
    }
}