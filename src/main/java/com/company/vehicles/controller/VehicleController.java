package com.company.vehicles.controller;

import com.company.vehicles.dto.OperationResponseDto;
import com.company.vehicles.dto.VehicleResponseDto;
import com.company.vehicles.dto.VehicleStockRequestDto;
import com.company.vehicles.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponseDto>> getAllActiveVehicles() {
        List<VehicleResponseDto> vehicles = vehicleService.getAllActiveVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/low-stock-expensive")
    public ResponseEntity<List<VehicleResponseDto>> getLowStockExpensiveVehicles() {
        List<VehicleResponseDto> vehicles = vehicleService.getLowStockExpensiveVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @PatchMapping("/delete/{model}")
    public ResponseEntity<OperationResponseDto> deleteVehicleByModel(@PathVariable String model) {
        OperationResponseDto response = vehicleService.deleteVehicleByModel(model);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/stock")
    public ResponseEntity<VehicleResponseDto> updateVehicleStock(@Valid @RequestBody VehicleStockRequestDto requestDto) {
        VehicleResponseDto vehicle = vehicleService.updateVehicleStock(requestDto);
        return ResponseEntity.ok(vehicle);
    }
}
