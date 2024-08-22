package com.example.capstone.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.YearMonth;

//this file adds new classes for sql table entities. each class represents a table in the database
@Entity
@Getter
@Setter
@ToString
@Table(name = "survey")

public class survey {

    @Getter
    @Setter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //configures way primary key is generated

    private int id;
    private String first_name;
    private String last_name;
    private int age;
    private YearMonth desired_date;
    private String desired_location;
    private String personality;
    private String style;
    @Column(unique = true)
    private String email;


    //getters & setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public YearMonth getDesired_date() {
        return desired_date;
    }

    public void setDesired_date(YearMonth desired_date) {
        this.desired_date = desired_date;
    }

    public String getDesired_location() {
        return desired_location;
    }

    public void setDesired_location(String desired_location) {
        this.desired_location = desired_location;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getStyle(){
        return style;
    }

    public void setStyle(String style){
        this.style = style;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
