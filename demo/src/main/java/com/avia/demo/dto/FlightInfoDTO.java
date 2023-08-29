package com.avia.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightInfoDTO {

    long departureFlightsCount;
    long arrivalFlightsCount;
    long departureBaggagePieces;
    long arrivalBaggagePieces;

}
