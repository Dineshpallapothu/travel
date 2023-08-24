package com.travel.exception;

public class NoBookingFoundException extends RuntimeException {
    public NoBookingFoundException(int id) {
        super("NO booking found on this id " + id);
    }
}
