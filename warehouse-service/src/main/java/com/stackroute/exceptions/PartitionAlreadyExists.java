package com.stackroute.exceptions;

public class PartitionAlreadyExists extends Exception {
    String message;

    public PartitionAlreadyExists(String message) {
        super(message);
        this.message = message;
    }
}
