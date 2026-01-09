package com.company.vehicles.exception;

public class VehicleNotFoundException extends RuntimeException {

    public VehicleNotFoundException(String message) {
        super(message);
    }
}
