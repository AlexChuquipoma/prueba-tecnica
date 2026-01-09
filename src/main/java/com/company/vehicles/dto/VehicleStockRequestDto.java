package com.company.vehicles.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class VehicleStockRequestDto {

    @NotNull(message = "id es requerido")
    private Long id;

    @NotNull(message = "el stock es requerido")
    @Min(value = 0, message = "el stock debe ser mayor o igual a 0")
    private Integer stock;

    public VehicleStockRequestDto() {
    }

    public VehicleStockRequestDto(Long id, Integer stock) {
        this.id = id;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
