package com.busreservation.model;

public class Booking {

    private int bookingId;
    private Passenger passenger;
    private Bus bus;

    public Booking(int bookingId, Passenger passenger, Bus bus) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.bus = bus;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Bus getBus() {
        return bus;
    }
}