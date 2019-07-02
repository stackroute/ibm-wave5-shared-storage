package com.stackroute.exception;

public class Exception extends java.lang.Exception {
    String message;


    public Exception(String message) {
        super(message);
        this.message = message;
    }
}
