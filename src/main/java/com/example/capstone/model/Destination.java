package com.example.capstone.model;

import jakarta.persistence.*;
import java.util.Set;


@Entity
@Table(name = "destination")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "description")
    private String description;

//    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Booking> bookings;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String name){
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

   public String getDescription() {
     return description;
    }

    //public void setDescription(String description) {
     //   this.description = description;
    //}

}
