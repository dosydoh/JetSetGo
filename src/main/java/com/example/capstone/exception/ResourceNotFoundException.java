package com.example.capstone.exception;

/**
 * Custom exception class to handle resource not found errors.
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}