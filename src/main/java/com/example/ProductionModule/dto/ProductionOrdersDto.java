package com.example.ProductionModule.dto;

import com.example.PlantsCarModule.entity.CarModel;
import com.example.PlantsCarModule.entity.ManufacturingPlant;
import com.example.ProductionModule.Status;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ProductionOrdersDto {
    //foreignkey
    private ManufacturingPlant manufacturingPlant;
    //foreignkey
    private CarModel carModel;
    private Status status;
    private int target_quantity;
    private int completed_quantity;
    private LocalDate expected_end_date;
    private LocalDate actual_end_date;
}
