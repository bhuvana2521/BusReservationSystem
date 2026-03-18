package com.busreservation.dao;

import com.busreservation.model.Bus;
import java.util.ArrayList;
import java.util.List;

public class BusDAO {

    private List<Bus> busList = new ArrayList<>();

    public void addBus(Bus bus) {
        busList.add(bus);
    }

    public List<Bus> getAllBuses() {
        return busList;
    }

    public Bus findBusById(int busId) {
        for (Bus bus : busList) {
            if (bus.getBusId() == busId) {
                return bus;
            }
        }
        return null;
    }
}