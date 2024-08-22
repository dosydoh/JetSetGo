package com.example.capstone.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//this file adds new classes for sql table entities. each class represents a table in the database
@Entity
@Getter
@Setter
@ToString
@Table(name = "customer_profile")

public class customer_profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //configures way primary key is generated
    @NonNull
    @Column(name = "id")
    private int id;

    private String first_name;
    @NonNull

    private String last_name;
    @NonNull

    private String location;
    private String interests;
    @Column(unique = true)
    private String email;
    @NonNull


    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public String getInterests(){
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
}
