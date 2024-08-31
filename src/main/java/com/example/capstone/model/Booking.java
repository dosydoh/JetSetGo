package com.example.capstone.model;

import jakarta.persistence.*;
//import jakarta.validation.constraints.Future;
//import java.time.LocalDate;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

   // @Column(name = "destination")
    //private String destination;



    public Booking() {

    }

    public Booking(String firstName, String lastName, String email) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id")
    //private User user;

   // @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "destination_id")
    //private Destination destination;

    //@Future(message = "Booking fate must be in the future")
    //private LocalDate bookingDate;

    // Getters and setters







//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Destination getDestination() {
//        return destination;
//    }
//
//    public void setDestination(Destination destination) {
//        this.destination = destination;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public LocalDate getBookingDate(){
//        return bookingDate;
//    }
//
//    public void setBookingDate(LocalDate bookingDate) {
//        this.bookingDate = bookingDate;
//    }
//}