package com.busreservation.ui;

import com.busreservation.dao.*;
import com.busreservation.model.*;
import com.busreservation.service.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BusDAO busDAO = new BusDAO();
        PassengerDAO passengerDAO = new PassengerDAO();
        BookingDAO bookingDAO = new BookingDAO();

        BookingService bookingService =
                new BookingService(busDAO, passengerDAO, bookingDAO);

        busDAO.addBus(new Bus(1, "Chennai", "Coimbatore", 2));
        busDAO.addBus(new Bus(2, "Madurai", "Trichy", 3));

        while (true) {

            System.out.println("\n1. View Buses");
            System.out.println("2. Book Ticket");
            System.out.println("3. View All Bookings");
            System.out.println("4. Update Passenger Name");
            System.out.println("5. Cancel Booking");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {

                for (Bus bus : busDAO.getAllBuses()) {
                    System.out.println("Bus ID: " + bus.getBusId()
                            + " | " + bus.getSource()
                            + " -> " + bus.getDestination()
                            + " | Available Seats: " + bus.getAvailableSeats());
                }

            } else if (choice == 2) {

                System.out.print("Enter Bus ID: ");
                int busId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Passenger Name: ");
                String name = scanner.nextLine();

                int bookingId = (int)(Math.random()*1000);

                Passenger passenger =
                        new Passenger((int)(Math.random()*1000), name);

                boolean success =
                        bookingService.createBooking(
                                bookingId,
                                busId,
                                passenger
                        );

                if (success) {
                    System.out.println("Booking Successful! Booking ID: " + bookingId);
                }

            } else if (choice == 3) {

                for (Booking booking : bookingService.getAllBookings()) {
                    System.out.println("Booking ID: " + booking.getBookingId()
                            + " | Passenger: " + booking.getPassenger().getName()
                            + " | Bus ID: " + booking.getBus().getBusId());
                }

            } else if (choice == 4) {

                System.out.print("Enter Booking ID: ");
                int bookingId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter New Passenger Name: ");
                String newName = scanner.nextLine();

                if (bookingService.updatePassengerName(bookingId, newName)) {
                    System.out.println("Passenger name updated successfully!");
                } else {
                    System.out.println("Booking not found!");
                }

            } else if (choice == 5) {

                System.out.print("Enter Booking ID to cancel: ");
                int bookingId = scanner.nextInt();

                if (bookingService.cancelBooking(bookingId)) {
                    System.out.println("Booking cancelled successfully!");
                } else {
                    System.out.println("Booking not found!");
                }

            } else if (choice == 6) {
                System.out.println("Thank you!");
                break;
            }
        }

        scanner.close();
    }
}