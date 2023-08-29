package com.avia.demo.repository;

import com.avia.demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>, CustomFlightRepository {

}
