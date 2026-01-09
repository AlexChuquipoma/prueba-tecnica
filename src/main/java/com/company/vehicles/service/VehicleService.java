package com.company.vehicles.service;

import com.company.vehicles.dto.OperationResponseDto;
import com.company.vehicles.dto.VehicleResponseDto;
import com.company.vehicles.dto.VehicleStockRequestDto;

import java.util.List;

public interface VehicleService {

    List<VehicleResponseDto> getAllActiveVehicles();

    List<VehicleResponseDto> getLowStockExpensiveVehicles();

    OperationResponseDto deleteVehicleByModel(String model);

    VehicleResponseDto updateVehicleStock(VehicleStockRequestDto requestDto);
}
