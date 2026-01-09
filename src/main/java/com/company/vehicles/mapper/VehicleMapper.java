package com.company.vehicles.mapper;

import com.company.vehicles.dto.VehicleResponseDto;
import com.company.vehicles.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

    public VehicleResponseDto toDto(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }

        return new VehicleResponseDto(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getPrice(),
                vehicle.getStock()
        );
    }
}
