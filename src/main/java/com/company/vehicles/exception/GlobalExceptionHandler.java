package com.company.vehicles.exception;

import com.company.vehicles.dto.OperationResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<OperationResponseDto> handleVehicleNotFound(VehicleNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new OperationResponseDto(ex.getMessage()));
    }

    @ExceptionHandler(VehicleAlreadyDeletedException.class)
    public ResponseEntity<OperationResponseDto> handleVehicleAlreadyDeleted(VehicleAlreadyDeletedException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new OperationResponseDto(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<OperationResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new OperationResponseDto("Invalid request data"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<OperationResponseDto> handleGenericException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new OperationResponseDto("An error occurred"));
    }
}
