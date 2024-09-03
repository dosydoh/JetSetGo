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
        model.addAttribute("users", bookings);
        return "booking";
    }

//    @GetMapping("/{id}/edit")
//    public String getBooking(@PathVariable Long id, Model model) {
//        Booking booking = bookingService.getBookingById(id);
//        model.addAttribute("booking", booking);
//        return "booking-details";
//    }

    @GetMapping("/new")    //////keep an eye on this one ////
    public String createBookingForm(Model model) {
        model.addAttribute("user", new Booking()); // Prepare an empty Booking object for the form
        return "create_user";
    }

    @PostMapping
    public String createBooking(@ModelAttribute Booking booking) {
        bookingService.createBooking(booking);
        return "redirect:/booking";
    }

    @GetMapping("/{id}/edit")
    public String editBookingForm(@PathVariable Long id, Model model) {
        Booking booking = bookingService.getBookingById(id);
        model.addAttribute("user", booking); // Prepare existing Booking object for editing
        return "edit_user";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateBooking(@PathVariable Long id, @ModelAttribute("user") Booking booking) {
        bookingService.updateBooking(id, booking);
        return "redirect:/booking";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "redirect:/booking";
    }
}