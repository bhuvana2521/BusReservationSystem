package com.busreservation.dao;

import com.busreservation.model.Passenger;
import java.util.ArrayList;
import java.util.List;

public class PassengerDAO {

    private List<Passenger> passengerList = new ArrayList<>();

    public void addPassenger(Passenger passenger) {
        passengerList.add(passenger);
    }

    public List<Passenger> getAllPassengers() {
        return passengerList;
    }
}