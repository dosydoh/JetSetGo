package com.example.capstone.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//this file adds new classes for sql table entities. each class represents a table in the database
@Entity
@Getter
@Setter
@ToString
@Table(name = "services")

public class services {
    @Getter
    @Setter

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //configures way primary key is generated

    private int id;


    //getters & setters
    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
