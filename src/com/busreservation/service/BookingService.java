package com.busreservation.service;

import com.busreservation.dao.*;
import com.busreservation.model.*;

import java.util.List;

public class BookingService {

    private BusDAO busDAO;
    private PassengerDAO passengerDAO;
    private BookingDAO bookingDAO;

    public BookingService(BusDAO busDAO, PassengerDAO passengerDAO, BookingDAO bookingDAO) {
        this.busDAO = busDAO;
        this.passengerDAO = passengerDAO;
        this.bookingDAO = bookingDAO;
    }

    // CREATE
    public boolean createBooking(int bookingId, int busId, Passenger passenger) {

        Bus bus = busDAO.findBusById(busId);

        if (bus == null) {
            System.out.println("Bus not found!");
            return false;
        }

        if (bus.getAvailableSeats() <= 0) {
            System.out.println("No seats available!");
            return false;
        }

        bus.bookSeat();
        passengerDAO.addPassenger(passenger);

        Booking booking = new Booking(bookingId, passenger, bus);
        bookingDAO.addBooking(booking);

        return true;
    }

    // READ
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    // DELETE
    public boolean cancelBooking(int bookingId) {
        Booking booking = bookingDAO.findBookingById(bookingId);

        if (booking != null) {
            booking.getBus().cancelSeat();
            return bookingDAO.deleteBooking(bookingId);
        }
        return false;
    }

    // UPDATE
    public boolean updatePassengerName(int bookingId, String newName) {
        Booking booking = bookingDAO.findBookingById(bookingId);
        if (booking != null) {
            booking.getPassenger().setName(newName);
            return true;
        }
        return false;
    }
}