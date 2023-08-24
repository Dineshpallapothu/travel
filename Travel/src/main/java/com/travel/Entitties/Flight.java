package com.travel.Entitties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.service.spi.InjectService;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pnr_no")
    private int pnrNo;
    @Column(name = "Flight_no")
    private int flightNo;
    @Column(name = "Booking_seat_no")
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

    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
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


    @Override
    public String toString() {
        return "Flight{" +
                "flightNo=" + flightNo +
                ", bookingSeatNo=" + bookingSeatNo +
                ", seatsAvailability=" + seatsAvailability +
                ", bookingId=" + bookingId +
                ", flights=" + booking +
                '}';
    }
}
