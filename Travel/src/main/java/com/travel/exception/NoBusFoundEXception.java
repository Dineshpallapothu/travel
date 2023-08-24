package com.travel.exception;

public class NoBusFoundEXception extends RuntimeException {
    public NoBusFoundEXception(int id) {
        super("No bus found on this id " + id);
    }
}
