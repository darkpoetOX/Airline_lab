package com.bnta.airline.controllers;

import com.bnta.airline.models.Flight;
import com.bnta.airline.models.FlightDTO;
import com.bnta.airline.models.Passenger;
import com.bnta.airline.repositories.FlightRepository;
import com.bnta.airline.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flights")
public class FlightController {
    @Autowired
    FlightService flightService;

//    Handles following:
//    * GET /passengers ...............INDEX route
//    * GET /passengers/:id ...........SHOW route

//    @GetMapping
//    public ResponseEntity<List<Flight>> getAllFlights(){
//        return new ResponseEntity(flightService.findAllFlights(), HttpStatus.OK);
//    }

    @GetMapping //with filters for destination
    public ResponseEntity<List<Flight>> getAllFlightsAndFilters(
            @RequestParam(required = false, name = "destination") String destination
    ){
        if (destination != null) {
            return new ResponseEntity<>(flightService.findAllFlightsDestination(destination), HttpStatus.OK);
        }
        return new ResponseEntity<>(flightService.findAllFlights(), HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlight(@PathVariable Long id){
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Flight> postFlight(@RequestBody FlightDTO flightDTO){
        Flight savedFlight = flightService.saveFlight(flightDTO);
        return new ResponseEntity<>(savedFlight, HttpStatus.CREATED);
    }

    @PostMapping("/book")
    public ResponseEntity<Flight> bookingPassengersOnFlight(@RequestBody FlightDTO flightDTO) {
        Flight bookedFlight = flightService.saveFlight(flightDTO);
        return new ResponseEntity<>(bookedFlight, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")    // ADDED
    public ResponseEntity<Flight> updateFlight(@RequestBody FlightDTO flightDTO, @PathVariable Long id){
        Flight updatedFlight = flightService.updateFlight(flightDTO, id);
        return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
    }
}
