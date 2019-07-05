package com.stackroute.exceptions;

public class PartitionNotFound extends Exception {
    String message;

    public PartitionNotFound(String message) {
        super(message);
        this.message = message;
    }
}
