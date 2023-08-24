package com.travel.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(int id) {
        super("user id is not valid" + id);
    }

}
