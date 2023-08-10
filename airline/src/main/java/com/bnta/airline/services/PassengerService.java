package com.bnta.airline.services;

import com.bnta.airline.models.Flight;
import com.bnta.airline.models.Passenger;
import com.bnta.airline.models.PassengerDTO;
import com.bnta.airline.repositories.FlightRepository;
import com.bnta.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    FlightRepository flightRepository;

    public Passenger savePassenger(PassengerDTO passengerDTO){
        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getPhoneNumber());
        for(Long flightId: passengerDTO.getFlightIds()){
            Flight flight = flightRepository.findById(flightId).get();
            passenger.addFlight(flight);
        }
        return passengerRepository.save(passenger);
    }

    public Passenger findPassenger(Long id) {
        return passengerRepository.findById(id).get();
    }


    public List<Passenger> findAllPassengers() {
        return passengerRepository.findAll();
    }

    public List<Passenger> findAllPassengersPhoneNumber(int number){
        return passengerRepository.findByPhoneNumber(number);
    }

    public Passenger updatePassenger(PassengerDTO passengerDTO, Long id){ // ADDED
        Passenger passengerToUpdate = passengerRepository.findById(id).get();
        passengerToUpdate.setName(passengerDTO.getName());
        passengerToUpdate.setPhoneNumber(passengerDTO.getPhoneNumber());
        // remove all existing flights
        passengerToUpdate.setFlights(new ArrayList<Flight>());
        // find and add flights
        for (Long flightId : passengerDTO.getFlightIds()){
            Flight flight = flightRepository.findById(flightId).get();
            passengerToUpdate.addFlight(flight);
        }
        passengerRepository.save(passengerToUpdate);
        return passengerToUpdate;
    }




}
