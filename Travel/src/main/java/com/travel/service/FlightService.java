package com.travel.service;

import com.travel.DTO.BusDto;
import com.travel.DTO.FlightDto;
import com.travel.DTO.TrainDto;
import com.travel.Entitties.Bus;
import com.travel.Entitties.Flight;
import com.travel.exception.NoBusException;
import com.travel.exception.NoBusFoundEXception;
import com.travel.exception.ObjectNoVAlidException;
import com.travel.repo.BusRepo;
import com.travel.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {
    @Autowired
    FlightRepo flightRepo;

    public List<FlightDto> getll() {
        List<Flight> buses = flightRepo.findallbus();
        if (buses.isEmpty()) {
            throw new NoBusException();
        } else {
            return buses.stream().map(this::ccnvert).collect(Collectors.toList());
        }
    }

    public FlightDto getbybookings(int id) {
        Flight flight = flightRepo.findbypnrId(id);
        if (flight == null) {
            throw new NoBusFoundEXception(id);
        } else {
            return ccnvert(flight);
        }
    }

    public FlightDto creatflight(FlightDto flightDto) {
        int seats = flightDto.getBookingSeatNo();
        int available = flightDto.getSeatsAvailability();
        if (flightDto == null || (seats < 0 && seats > 30) || (available > 30 && available < 0)) {
            throw new ObjectNoVAlidException();
        } else {
            Flight flight = new Flight();
            flight.setFlightNo(flightDto.getFlightNo());
            flight.setBookingId(flightDto.getBookingId());
            flight.setSeatsAvailability(flightDto.getSeatsAvailability());
            flight.setBookingSeatNo(flightDto.getBookingSeatNo());
            flightRepo.save(flight);
            return ccnvert(flight);
        }
    }

    public FlightDto updateflight(int id, FlightDto flightDto) {
        int seats = flightDto.getBookingSeatNo();
        int available = flightDto.getSeatsAvailability();
        Flight flight = flightRepo.findbypnrId(id);

        if (flightDto == null || (seats < 0 && seats > 30) || (available > 30 && available < 0)) {
            throw new ObjectNoVAlidException();
        } else {
            flight.setBookingSeatNo(flightDto.getBookingSeatNo());
            flightRepo.save(flight);
            return ccnvert(flight);
        }
    }

    public FlightDto removeflight(int id) {
        Flight flight = flightRepo.findbypnrId(id);
        if (flight == null) {
            throw new NoBusException();
        } else {
            flightRepo.delete(flight);
            return ccnvert(flight);
        }
    }


    public FlightDto ccnvert(Flight flight) {
        FlightDto flightDto = new FlightDto();
        flightDto.setFlightNo(flight.getFlightNo());
        flightDto.setBookingSeatNo(flight.getBookingSeatNo());
        flightDto.setBookingId(flight.getBookingId());
        flightDto.setSeatsAvailability(flight.getSeatsAvailability());
        return flightDto;
    }
}
