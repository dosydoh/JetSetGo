package com.example.capstone.services;

import java.util.List;
import com.example.capstone.model.Destination;

/**
 * Service interface for handling Destination operations.
 */
public interface DestinationService {
    Destination createDestination(Destination destination);
    Destination getDestinationById(Long id);
    List<Destination> getAllDestinations();
    Destination updateDestination(Long id, Destination destination);
    void deleteDestination(Long id);
}