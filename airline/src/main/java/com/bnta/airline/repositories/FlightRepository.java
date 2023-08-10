package com.bnta.airline.repositories;

import com.bnta.airline.models.Flight;
import com.bnta.airline.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    //    find all flights' destination
    List<Flight> findByDestination(String destination);
}
