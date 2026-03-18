package com.busreservation.model;

public class Passenger {

    private int passengerId;
    private String name;

    // Constructor
    public Passenger(int passengerId, String name) {
        this.passengerId = passengerId;
        this.name = name;
    }

    // Getters
    public int getPassengerId() {
        return passengerId;
    }

    public String getName() {
        return name;
    }

    // Setter (needed for UPDATE operation)
    public void setName(String name) {
        this.name = name;
    }
}