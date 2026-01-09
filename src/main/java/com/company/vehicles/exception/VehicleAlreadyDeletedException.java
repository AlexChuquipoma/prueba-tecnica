package com.company.vehicles.exception;

public class VehicleAlreadyDeletedException extends RuntimeException {

    public VehicleAlreadyDeletedException(String message) {
        super(message);
    }
}
