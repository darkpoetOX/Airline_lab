package com.bnta.airline.services;

import com.bnta.airline.models.Flight;
import com.bnta.airline.models.FlightDTO;
import com.bnta.airline.models.Passenger;
import com.bnta.airline.models.PassengerDTO;
import com.bnta.airline.repositories.FlightRepository;
import com.bnta.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public Flight saveFlight(FlightDTO flightDTO){
        Flight flight = new Flight(flightDTO.getDestination(), flightDTO.getCapacity(), flightDTO.getDepartureDate(), flightDTO.getDepartureTime());
        for(Long passengerId: flightDTO.getPassengerIds()){
            Passenger passenger = passengerRepository.findById(passengerId).get();
            flight.addPassenger(passenger);
        }
        return flightRepository.save(flight);
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight findFlight(Long id) {
        return flightRepository.findById(id).get();
    }

    public void deleteFlight(Long id) {flightRepository.deleteById(id);}

    public List<Flight> findAllFlightsDestination(String city){
        return flightRepository.findByDestination(city);
    }

    public Flight updateFlight(FlightDTO flightDTO, Long id){ // ADDED
        Flight flightToUpdate = flightRepository.findById(id).get();
        flightToUpdate.setDestination(flightDTO.getDestination());
        flightToUpdate.setCapacity(flightDTO.getCapacity());
        flightToUpdate.setDepartureDate(flightDTO.getDepartureDate());
        flightToUpdate.setDepartureTime(flightDTO.getDepartureTime());

        // remove all existing passengers
        flightToUpdate.setPassengers(new ArrayList<Passenger>());
        // find and add passengers
        for (Long passengerId : flightDTO.getPassengerIds()){
            Passenger passenger = passengerRepository.findById(passengerId).get();
            flightToUpdate.addPassenger(passenger);
        }
        flightRepository.save(flightToUpdate);
        return flightToUpdate;
    }

}
