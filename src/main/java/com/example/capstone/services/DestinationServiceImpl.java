package com.example.capstone.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.capstone.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.example.capstone.model.Destination;
import com.example.capstone.repository.DestinationRepository;

/**
 * Service implementation for handling Destination operations.
 */
@Service
@Transactional
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    @Override
    public Destination createDestination(Destination destination) {
        return destinationRepository.save(destination);
    }

    @Override
    public Destination getDestinationById(Long id) {
        return destinationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Destination not found with id " + id));
    }

    @Override
    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    @Override
    public Destination updateDestination(Long id, Destination destination) {
        if (!destinationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Destination not found with id " + id);
        }
        destination.setId(id);
        return destinationRepository.save(destination);
    }

    @Override
    public void deleteDestination(Long id) {
        if (!destinationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Destination not found with id " + id);
        }
        destinationRepository.deleteById(id);
    }
}