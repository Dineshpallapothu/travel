package com.travel.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.travel.Entitties.Booking;
import jakarta.persistence.Column;

public class TrainDto {

    private int trainNo;

    private int bookingSeatNo;

    private int seatsAvailability;

    private int bookingId;

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @JsonIgnore
    private Booking booking;

    public int getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(int trainNo) {
        this.trainNo = trainNo;
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
}
