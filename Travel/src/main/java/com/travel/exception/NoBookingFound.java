package com.travel.exception;

public class NoBookingFound extends RuntimeException {
    public NoBookingFound(int id) {
        super("NO Booking Found on this ID" + id);
    }
}
