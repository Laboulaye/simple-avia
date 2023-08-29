package com.avia.demo.controller;

import com.avia.demo.dto.FlightInfoDTO;
import com.avia.demo.model.Flight;
import com.avia.demo.dto.CargoInfoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.avia.demo.service.FlightService;

import java.util.Date;
import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private FlightService service;

    @Operation(summary = "Get aggregate cargo weight info")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = CargoInfoDTO.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "There are no flights on this date. Check your input data carefully",
                    content = @Content) })
    @GetMapping("/cargoInfo")
    public ResponseEntity<CargoInfoDTO> getCargoInfo(@Parameter(name = "date", description = "Date in ISO format", example = "2017-02-12")
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date,
                                                     @Parameter(name = "flightNumber", description = "Flight number", example = "7318")
                                                        @RequestParam int flightNumber) {
        return new ResponseEntity<>(service.getCargoInfo(date, flightNumber), HttpStatus.OK);
    }

    @Operation(summary = "Get count of flights and count of pieces")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = FlightInfoDTO.class),
                    mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "There are no flights on this date. Check your input data carefully",
                    content = @Content) })
    @GetMapping("/flightInfo")
    public ResponseEntity<FlightInfoDTO> getFlightInfo(@Parameter(name = "date", description = "Date in ISO format", example = "2017-02-12")
                                                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date date,
                                                       @Parameter(name = "airportCode", description = "Airport IATA Code", example = "LEW")
                                                            @RequestParam String airportCode) {
        return new ResponseEntity<>(service.getFlightInfo(date, airportCode), HttpStatus.OK);
    }

    @Operation(summary = "Get all flights and cargo")
    @GetMapping("/flights")
    public List<Flight> getFlights(){
        return service.getFlights();
    }
}
