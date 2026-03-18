package com.busreservation.model;

public class Bus {

    private int busId;
    private String source;
    private String destination;
    private int totalSeats;
    private int availableSeats;

    // Constructor
    public Bus(int busId, String source, String destination, int totalSeats) {
        this.busId = busId;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // Initially all seats available
    }

    // Getters
    public int getBusId() {
        return busId;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    // Reduce seat when booking
    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    // Increase seat when cancelling
    public void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }
}