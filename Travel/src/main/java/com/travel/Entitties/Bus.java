package com.travel.Entitties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

//openjdk async solve
@Entity
@Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pnr_no")
    private int pnrNo;
    @Column(name = "Bus_no")
    private int busNo;
    @Column(name = "Booking_seatno")
    private int bookingSeatno;
    @Column(name = " Seats_availability")
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

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public int getBookingId() {
        return bookingId;
    }

    public int getBookingSeatno() {
        return bookingSeatno;
    }

    public void setBookingSeatno(int bookingSeatno) {
        this.bookingSeatno = bookingSeatno;
    }

    public Booking getBookings() {
        return booking;
    }

    public void setBookings(Booking bookings) {
        this.booking = bookings;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public int getSeatsAvailability() {
        return seatsAvailability;
    }

    public void setSeatsAvailability(int seatsAvailability) {
        this.seatsAvailability = seatsAvailability;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNo=" + busNo +
                ", bookingSeatno=" + bookingSeatno +
                ", seatsAvailability=" + seatsAvailability +
                ", bookingId=" + bookingId +
                ", bookings=" + booking +
                '}';
    }
}
