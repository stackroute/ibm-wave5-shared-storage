package com.stackroute.exceptions;

    public class StorageUnitAlreadyExistsException extends Exception{

        String message;
        public StorageUnitAlreadyExistsException(String message) {
            super(message);
            this.message = message;
        }
    }

