package com.example.capstone.controllers;

import com.example.capstone.model.Booking;
import com.example.capstone.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling Booking related web requests.
 */
@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public String listBookings(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("booking", bookings);
        return "booking";
    }

    @GetMapping("/{id}")
    public String getBooking(@PathVariable Long id, Model model) {
        Booking booking = bookingService.getBookingById(id);
        model.addAttribute("booking", booking);
        return "booking-details";
    }

    @PostMapping
    public String createBooking(@ModelAttribute Booking booking) {
        bookingService.createBooking(booking);
        return "redirect:/booking";
    }

    @PutMapping("/{id}")
    public String updateBooking(@PathVariable Long id, @ModelAttribute Booking booking) {
        bookingService.updateBooking(id, booking);
        return "redirect:/booking";
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "redirect:/bookings";
    }
}