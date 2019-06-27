package com.stackroute.exceptions;

public class WarehouseAlreadyExistsException extends Exception {
    String message;


    public WarehouseAlreadyExistsException(String message) {
        super(message);
        this.message = message;
    }
}
