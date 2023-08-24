package com.travel.Entitties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pnr_no")
    private int pnrNo;
    @Column(name = "Train_no")
    private int trainNo;
    @Column(name = "Booking_Seat_no")
    private int bookingSeatNo;
    @Column(name = "Seats_availability")
    private int seatsAvailability;
    @Column(name = "Booking_id")
    private int bookingId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Booking_id", insertable = false, updatable = false)
    @JsonIgnore
    private Booking booking;

    public int getPnrNo() {
        return pnrNo;
    }

    public void setPnrNo(int pnrNo) {
        this.pnrNo = pnrNo;
    }

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

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
