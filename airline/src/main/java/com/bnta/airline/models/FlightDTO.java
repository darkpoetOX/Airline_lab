package com.bnta.airline.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class FlightDTO {
    private String destination;
    private int capacity;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private List<Long> passengerIds;

    public FlightDTO(String destination, int capacity, LocalDate departureDate, LocalTime departureTime, List<Long> passengerIds) {
        this.destination = destination;
        this.capacity = capacity;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.passengerIds = passengerIds; //these will not be empty, so we do not need empty arraylist
    }

    public FlightDTO(){}

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public List<Long> getPassengerIds() {
        return passengerIds;
    }

    public void setPassengerIds(List<Long> passengerIds) {
        this.passengerIds = passengerIds;
    }
}
