package com.bnta.airline.controllers;

import com.bnta.airline.models.Passenger;
import com.bnta.airline.models.PassengerDTO;
import com.bnta.airline.repositories.PassengerRepository;
import com.bnta.airline.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("passengers")
public class PassengerController {

    @Autowired
    PassengerService passengerService;
//    Handles following:
//    * GET /passengers ...............INDEX route
//    * GET /passengers/:id ...........SHOW route

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        List<Passenger> chocolates = passengerService.findAllPassengers();
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        return new ResponseEntity(passengerService.findPassenger(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Passenger> postPassenger(@RequestBody PassengerDTO passengerDTO){
        Passenger savedPassenger = passengerService.savePassenger(passengerDTO);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")    // ADDED
    public ResponseEntity<Passenger> updatePassenger(@RequestBody PassengerDTO passengerDTO, @PathVariable Long id){
        Passenger updatedPassenger= passengerService.updatePassenger(passengerDTO, id);
        return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
    }
    
}
