package com.stackroute.exceptions;

public class WarehouseNotfound extends Exception {
    String message;


    public WarehouseNotfound(String message) {
        super(message);
        this.message = message;
    }
}
