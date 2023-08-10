package com.bnta.airline.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passengers")

public class Passenger {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column
   private Long id;

   @Column
   private String name;
   @Column
   private int phoneNumber;

   @ManyToMany
   @JsonIgnoreProperties({"passengers"})
   @JoinTable(
           name = "passengers_flights",
           joinColumns = @JoinColumn(name = "passenger_id"),
           inverseJoinColumns = @JoinColumn(name = "flight_id")
   )

   private List<Flight> flights;

   public Passenger(String name, int phoneNumber){
      this.name = name;
      this.phoneNumber = phoneNumber;
      this.flights = new ArrayList<>();
      }

   public Passenger(){}


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

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

   public List<Flight> getFlights() {
      return flights;
   }

   public void setFlights(List<Flight> flights) {
      this.flights = flights;
   }

   public void addFlight(Flight flight){
      this.flights.add(flight);
   }

}