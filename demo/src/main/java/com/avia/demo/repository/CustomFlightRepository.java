package com.avia.demo.repository;

import com.avia.demo.dto.CargoInfoDTO;
import com.avia.demo.dto.FlightInfoDTO;

import java.util.Date;

public interface CustomFlightRepository {

    CargoInfoDTO findAggregateCargoInfo(Date date, int flightNumber);

    FlightInfoDTO findAggregateFlightInfo(Date date, String airportCode);
}
