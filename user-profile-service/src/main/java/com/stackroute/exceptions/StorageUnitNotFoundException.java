package com.stackroute.exceptions;

public class StorageUnitNotFoundException extends  Exception{
    String message;

    public StorageUnitNotFoundException() {
    }
    public StorageUnitNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}