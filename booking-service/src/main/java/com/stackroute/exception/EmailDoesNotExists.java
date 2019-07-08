package com.stackroute.exception;

public class EmailDoesNotExists extends Exception {
    String message;

    public EmailDoesNotExists(String message) {
        super(message);
        this.message = message;
    }
}