package com.travel.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.Entitties.Booking;

public class BusDto {
    private int busNo;
    private int bookingSeatno;
    private int seatsAvailability;
    private int bookingId;
    @JsonIgnore
    private BookingDto booking;

    public BookingDto getBooking() {
        return booking;
    }

    public void setBooking(BookingDto booking) {
        this.booking = booking;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public int getBookingSeatno() {
        return bookingSeatno;
    }

    public void setBookingSeatno(int bookingSeatno) {
        this.bookingSeatno = bookingSeatno;
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
}
