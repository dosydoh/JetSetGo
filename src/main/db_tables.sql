-- Create User table
CREATE TABLE User (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,           -- User's first name
    last_name VARCHAR(255) NOT NULL,            -- User's last name
    email VARCHAR(255) UNIQUE NOT NULL,         -- User's email address (unique)
    password VARCHAR(255) NOT NULL);             -- User's hashed password


-- Create Role table
CREATE TABLE Role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL            -- Role name (e.g., 'ROLE_USER', 'ROLE_ADMIN')
);

-- Create User_Role join table
CREATE TABLE User_Role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role BIGINT);

-- Create Destination table
CREATE TABLE Destination (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,                 -- Destination name
    location VARCHAR(255),                     -- Location of the destination
    price DECIMAL(10, 2) NOT NULL);             -- Price for the destination


-- Create Review table
CREATE TABLE Review (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    destination text,
    rating INT CHECK (rating >= 1 AND rating <= 5),  -- Rating from 1 to 5
    comment TEXT);

-- Create Booking table
CREATE TABLE Booking (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    destination TEXT,
    number_of_people INT NOT NULL,                    -- Number of people for the booking
    total_price DECIMAL(10, 2) NOT NULL);              -- Total price for the booking

-- Insert some initial roles
INSERT INTO Role (name) VALUES ('ROLE_USER');
INSERT INTO Role (name) VALUES ('ROLE_ADMIN');
