package com.travel.service;

import com.travel.DTO.BookingDto;
import com.travel.DTO.BusDto;
import com.travel.Entitties.Booking;
import com.travel.Entitties.Bus;
import com.travel.exception.NoBusException;
import com.travel.exception.NoBusFoundEXception;
import com.travel.exception.ObjectNoVAlidException;
import com.travel.repo.BusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.IconView;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusService {

    @Autowired
    BusRepo busRepo;
    BookingService bookingService;

    public List<BusDto> getll() {
        List<Bus> buses = busRepo.findallbus();
        if (buses.isEmpty()) {
            throw new NoBusException();
        } else {
            return buses.stream().map(this::ccnvert).collect(Collectors.toList());
        }
    }

    public BusDto getbybookings(int id) {
        Bus bus = busRepo.findbypnrId(id);
        if (bus == null) {
            throw new NoBusFoundEXception(id);
        } else {
            return ccnvert(bus);
        }
    }

    public BusDto createbus(BusDto busDto) {
        int seats = busDto.getBookingSeatno();
        int available = busDto.getSeatsAvailability();
        if (busDto == null || (seats < 0 && seats > 20) || (available >= 20 && available < 0)) {
            throw new ObjectNoVAlidException();
        } else {
            Bus bus = new Bus();
            bus.setBusNo(busDto.getBusNo());
            bus.setBookingId(busDto.getBookingId());
            bus.setSeatsAvailability(busDto.getSeatsAvailability());
            bus.setBookingSeatno(busDto.getBookingSeatno());
            busRepo.save(bus);
            return ccnvert(bus);
        }
    }

    public BusDto updatebus(int id, BusDto busDto) {
        int seats = busDto.getBookingSeatno();
        int available = busDto.getSeatsAvailability();
        if (busDto == null || (seats < 0 && seats > 20) || (available > 20 && available < 0)) {
            throw new ObjectNoVAlidException();
        } else {
            Bus bus = busRepo.findbypnrId(id);
            bus.setBookingSeatno(busDto.getBookingSeatno());
            busRepo.save(bus);
            return ccnvert(bus);
        }
    }

    public BusDto removebus(int id) {
        Bus bus = busRepo.findbypnrId(id);
        if (bus == null) {
            throw new NoBusException();
        } else {
            busRepo.delete(bus);
            return ccnvert(bus);
        }
    }


    public BusDto ccnvert(Bus bus) {
        BusDto busDto = new BusDto();
        busDto.setBusNo(bus.getBusNo());
        busDto.setBookingSeatno(bus.getBookingSeatno());
        busDto.setBookingId(bus.getBookingId());
        busDto.setSeatsAvailability(bus.getSeatsAvailability());
        return busDto;
    }
}
