package com.example.wanderwisep.model;

import com.example.wanderwisep.enumeration.userRole;

import java.util.Vector;

public class User {
    private String name;
    private String surname;
    private String email;
    private userRole role;

    private Vector<Ticket> myTicket;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public userRole getRole() {
        return role;
    }

    public void setRole(userRole role) {
        this.role = role;
    }

    public Vector<Ticket> getMyTicket() {
        return myTicket;
    }

    public void setMyTicket(Vector<Ticket> myTicket) {
        this.myTicket = myTicket;
    }

    public User(String name, String surname, String email, userRole type) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.role = type;
    }
}
