package com.travel.controllers;

import com.travel.DTO.BookingDto;
import com.travel.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping("/all")
    public List<BookingDto> getallbookings() {
        return bookingService.getall();
    }

    @GetMapping("/booking")
    public BookingDto findbooking(@RequestParam("id") int id) {
        return bookingService.getbooking(id);
    }

    @GetMapping("/UserBooking")
    public List<BookingDto> finduserbooking(@RequestParam("uid") int uid) {
        return bookingService.getuserbooking(uid);
    }

    @GetMapping("/detils")
    public BookingDto getdetails(@RequestParam("id") int id) {
        return bookingService.findetsils(id);
    }

    @GetMapping("/detils/flight")
    public BookingDto getdetailsflight(@RequestParam("id") int id) {
        return bookingService.findetsilsflight(id);
    }

    @GetMapping("/detils/train")
    public BookingDto getdetailstrain(@RequestParam("id") int id) {
        return bookingService.findetsilstrain(id);
    }


    @PostMapping("/create")
    public BookingDto createbooking(@RequestBody BookingDto bookingDto) {
        return bookingService.createbooking(bookingDto);
    }

    @PutMapping("/update")
    public BookingDto updtebooking(@RequestParam("id") int id, @RequestBody BookingDto bookingDto) {
        return bookingService.update(id, bookingDto);
    }

    @DeleteMapping("/remove")
    public BookingDto remove(@RequestParam("id") int id) {
        return bookingService.removebooking(id);
    }

}
