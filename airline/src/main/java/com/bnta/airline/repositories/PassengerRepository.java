package com.bnta.airline.repositories;

import com.bnta.airline.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    //    find all passengers' phone number
    List<Passenger> findByPhoneNumber(int phoneNumber);
}
