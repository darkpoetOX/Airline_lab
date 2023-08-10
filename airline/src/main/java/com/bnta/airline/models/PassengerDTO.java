package com.bnta.airline.models;

import java.util.List;

public class PassengerDTO {
    private String name;
    private int phoneNumber;
    private List<Long> flightIds;

    public PassengerDTO(String name, int phoneNumber, List<Long> flightIds) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.flightIds = flightIds; //these will not be empty, so we do not need empty arraylist
    }

    public PassengerDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Long> getFlightIds() {
        return flightIds;
    }

    public void setFlightIds(List<Long> flightIds) {
        this.flightIds = flightIds;
    }
}
