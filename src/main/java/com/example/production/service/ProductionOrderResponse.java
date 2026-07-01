package com.example.production.service;

import com.example.production.dto.CarModelDto;
import com.example.production.dto.ManufacturingPlantDto;
import com.example.production.dto.ProductionOrdersDto;
import lombok.*;

@Data
public class ProductionOrderResponse {
    private ProductionOrdersDto productionOrder;

    private ManufacturingPlantDto manufacturingPlant;

    private CarModelDto carModel;
}
