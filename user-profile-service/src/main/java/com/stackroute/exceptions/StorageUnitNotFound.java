package com.stackroute.exceptions;

public class StorageUnitNotFound extends  Exception{
    String message;


    public StorageUnitNotFound(String message) {
        super(message);
        this.message = message;
    }
}
