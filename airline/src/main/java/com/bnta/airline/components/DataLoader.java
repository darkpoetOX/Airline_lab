package com.bnta.airline.components;

import com.bnta.airline.models.Flight;
import com.bnta.airline.models.Passenger;
import com.bnta.airline.repositories.FlightRepository;
import com.bnta.airline.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception  {

        // Create and save flights
        List<Flight> flights = Arrays.asList(
                new Flight("Jakarta", 160, LocalDate.of(2023, 7, 12), LocalTime.of(9, 30)),
                new Flight("Pasadena", 190, LocalDate.of(2023, 6, 2), LocalTime.of(9, 0)),
                new Flight("Sydney", 220, LocalDate.of(2023, 5, 4), LocalTime.of(11, 00)),
                new Flight("Lagos", 210, LocalDate.of(2023, 8, 10), LocalTime.of(22, 15))
        );
        flightRepository.saveAll(flights);

        // Create and save passengers
        List<Passenger> passengers = Arrays.asList(
                new Passenger("James", 55689000),
                new Passenger("Rebecca", 245789959),
                new Passenger("Callum", 289764903),
                new Passenger("Sara", 799678903)
        );
        passengerRepository.saveAll(passengers);

        //Adding a passenger to a flight
        Passenger passenger1 = new Passenger("Charlotte", 856678904);
        passengerRepository.save(passenger1);
        Flight flight1 = new Flight("Belize", 202, LocalDate.of(2024, 12, 21), LocalTime.of(2, 0));
        flight1.addPassenger(passenger1);

        //Adding multiple passengers to a flight
        flights.get(0).getPassengers().addAll(passengers); //adding all passengers from the list to a single (the first) flight
        flights.get(1).getPassengers().addAll(passengers.subList(1, 4)); //adding multiple passengers (second, third and fourth) from the list to a single (the second) flight
        flightRepository.saveAll(flights);

        //Adding a flight to a passenger
        Flight flight2 = new Flight("Paris", 235, LocalDate.of(2024, 8, 11), LocalTime.of(23, 0));
        flightRepository.save(flight2);
        Passenger passenger2 = new Passenger("Hannah", 687774563);
        passenger2.addFlight(flight2);

        //Adding multiple flights to a passenger
        passengers.get(0).getFlights().addAll(flights.subList(0, 4));
        passengers.get(1).getFlights().addAll(flights.subList(1, 3));
        passengerRepository.saveAll(passengers);
    }
}
