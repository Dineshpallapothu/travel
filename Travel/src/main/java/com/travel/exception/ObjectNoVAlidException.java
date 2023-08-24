package com.travel.exception;

public class ObjectNoVAlidException extends RuntimeException {
    public ObjectNoVAlidException() {
        super("give some valid data");
    }

}
