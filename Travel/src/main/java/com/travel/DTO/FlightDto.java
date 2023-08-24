package com.travel.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.Entitties.Booking;
import jakarta.persistence.Column;

public class FlightDto {
    private int flightNo;

    private int bookingSeatNo;

    private int seatsAvailability;

    @JsonIgnore
    private BookingDto booking;

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public int getBookingSeatNo() {
        return bookingSeatNo;
    }

    public void setBookingSeatNo(int bookingSeatNo) {
        this.bookingSeatNo = bookingSeatNo;
    }

    public int getSeatsAvailability() {
        return seatsAvailability;
    }

    public void setSeatsAvailability(int seatsAvailability) {
        this.seatsAvailability = seatsAvailability;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    private int bookingId;

    public BookingDto getBooking() {
        return booking;
    }

    public void setBooking(BookingDto booking) {
        this.booking = booking;
    }


}
