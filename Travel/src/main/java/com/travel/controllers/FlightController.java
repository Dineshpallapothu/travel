package com.travel.controllers;

import com.travel.DTO.BusDto;
import com.travel.DTO.FlightDto;
import com.travel.DTO.TrainDto;
import com.travel.service.FlightService;
import com.travel.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
    @Autowired
    FlightService flightService;

    @GetMapping("/all")
    public List<FlightDto> getalltrain() {
        return flightService.getll();
    }

    @GetMapping("/bus/booking")
    public FlightDto gettrainBooking(@RequestParam("id") int id) {
        return flightService.getbybookings(id);
    }

    @PostMapping("/create")
    public FlightDto creattrain(@RequestBody FlightDto flightDto) {
        return flightService.creatflight(flightDto);
    }

    @PutMapping("/update")
    public FlightDto update(@RequestParam("id") int id, @RequestBody FlightDto flightDto) {
        return flightService.updateflight(id, flightDto);
    }

    @DeleteMapping("/remove")
    public FlightDto remove(@RequestParam("id") int id) {
        return flightService.removeflight(id);
    }
}
