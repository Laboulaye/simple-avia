package com.avia.demo.service;

import com.avia.demo.dto.FlightInfoDTO;
import com.avia.demo.model.Flight;
import com.avia.demo.dto.CargoInfoDTO;
import com.avia.demo.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository repository;

    public CargoInfoDTO getCargoInfo(Date date, int flightNumber) {
        return repository.findAggregateCargoInfo(date, flightNumber);

    }

    public FlightInfoDTO getFlightInfo(Date date, String airportCode){
        return repository.findAggregateFlightInfo(date, airportCode);
    }

    public List<Flight> getFlights(){
        return repository.findAll();
    }
}
