package com.busreservation.dao;

import com.busreservation.model.Booking;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    private List<Booking> bookingList = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingList;
    }

    // Find booking by ID
    public Booking findBookingById(int bookingId) {
        for (Booking booking : bookingList) {
            if (booking.getBookingId() == bookingId) {
                return booking;
            }
        }
        return null;
    }

    // Delete booking
    public boolean deleteBooking(int bookingId) {
        Booking booking = findBookingById(bookingId);
        if (booking != null) {
            bookingList.remove(booking);
            return true;
        }
        return false;
    }
}