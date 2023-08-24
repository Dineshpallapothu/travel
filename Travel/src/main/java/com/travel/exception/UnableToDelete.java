package com.travel.exception;

public class UnableToDelete extends RuntimeException {
    public UnableToDelete(int id) {
        super("Unable to Delete this User " + id);
    }

}
