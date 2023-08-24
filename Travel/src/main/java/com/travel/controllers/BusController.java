package com.travel.controllers;

import com.travel.DTO.BookingDto;
import com.travel.DTO.BusDto;
import com.travel.Entitties.Booking;
import com.travel.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {
    @Autowired
    BusService busService;

    @GetMapping("/all")
    public List<BusDto> getallbus() {
        return busService.getll();
    }

    @GetMapping("/bus/booking")
    public BusDto getbusBooking(@RequestParam("id") int id) {
        return busService.getbybookings(id);
    }

    @PostMapping("/create")
    public BusDto createbus(@RequestBody BusDto busDto) {
        return busService.createbus(busDto);
    }

    @PutMapping("/update")
    public BusDto update(@RequestParam("id") int id, @RequestBody BusDto busDto) {
        return busService.updatebus(id, busDto);
    }

    @DeleteMapping("/remove")
    public BusDto remove(@RequestParam("id") int id) {
        return busService.removebus(id);
    }
}
