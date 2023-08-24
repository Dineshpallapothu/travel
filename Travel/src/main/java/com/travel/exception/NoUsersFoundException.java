package com.travel.exception;

public class NoUsersFoundException extends RuntimeException {

    public NoUsersFoundException() {
        super("No users found.");
    }
}
