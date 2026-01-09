package com.company.vehicles.service.impl;

import com.company.vehicles.dto.OperationResponseDto;
import com.company.vehicles.dto.VehicleResponseDto;
import com.company.vehicles.dto.VehicleStockRequestDto;
import com.company.vehicles.entity.Vehicle;
import com.company.vehicles.exception.VehicleAlreadyDeletedException;
import com.company.vehicles.exception.VehicleNotFoundException;
import com.company.vehicles.mapper.VehicleMapper;
import com.company.vehicles.repository.VehicleRepository;
import com.company.vehicles.service.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    public VehicleServiceImpl(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehicleResponseDto> getAllActiveVehicles() {
        List<Vehicle> activeVehicles = vehicleRepository.findByDeleted("N");
        return activeVehicles.stream()
                .map(vehicleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehicleResponseDto> getLowStockExpensiveVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findByDeletedAndPriceGreaterThanAndStockLessThan("N", 20000.0, 10);
        return vehicles.stream()
                .map(vehicleMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OperationResponseDto deleteVehicleByModel(String model) {
        Vehicle vehicle = vehicleRepository.findByModel(model)
                .orElseThrow(() -> new VehicleNotFoundException("Vehiculo no encontrado"));

        if ("S".equals(vehicle.getDeleted())) {
            throw new VehicleAlreadyDeletedException("Vehicle is already deleted");
        }

        vehicle.setDeleted("S");
        vehicleRepository.save(vehicle);

        return new OperationResponseDto("Vehicle deleted successfully");
    }

    @Override
    @Transactional
    public VehicleResponseDto updateVehicleStock(VehicleStockRequestDto requestDto) {
        Vehicle vehicle = vehicleRepository.findById(requestDto.getId())
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found"));

        vehicle.setStock(requestDto.getStock());
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);

        return vehicleMapper.toDto(updatedVehicle);
    }
}
