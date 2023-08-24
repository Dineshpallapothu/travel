package com.travel.exception;

public class NoBusException extends RuntimeException {
    public NoBusException() {
        super("No bus avilable");
    }
}
