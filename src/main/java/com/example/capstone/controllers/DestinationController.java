package com.example.capstone.controllers;

import com.example.capstone.model.Destination;
import com.example.capstone.services.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling Destination related web requests.
 */
@Controller
@RequestMapping("/destinations")
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping
    public String listDestinations(Model model) {
        List<Destination> destinations = destinationService.getAllDestinations();
        model.addAttribute("destinations", destinations);
        return "destinations";
    }

    @GetMapping("/{id}")
    public String getDestination(@PathVariable Long id, Model model) {
        Destination destination = destinationService.getDestinationById(id);
        model.addAttribute("destination", destination);
        return "destination-details";
    }

    @PostMapping
    public String createDestination(@ModelAttribute Destination destination) {
        destinationService.createDestination(destination);
        return "redirect:/destinations";
    }

    @PutMapping("/{id}")
    public String updateDestination(@PathVariable Long id, @ModelAttribute Destination destination) {
        destinationService.updateDestination(id, destination);
        return "redirect:/destinations";
    }

    @DeleteMapping("/{id}")
    public String deleteDestination(@PathVariable Long id) {
        destinationService.deleteDestination(id);
        return "redirect:/destinations";
    }
}