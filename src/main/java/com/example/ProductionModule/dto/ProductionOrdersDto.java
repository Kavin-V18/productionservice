package com.example.ProductionModule.dto;

import com.example.PlantsCarModule.entity.CarModel;
import com.example.PlantsCarModule.entity.ManufacturingPlant;
import com.example.ProductionModule.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductionOrdersDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private String order_number;
    //foreignkey
    private ManufacturingPlant manufacturingPlant;
    //foreignkey
    private CarModel carModel;
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    @Column(nullable = false)
    @Min(1)
    private int target_quantity;
    @Min(0)
    private int completed_quantity;
    private LocalDate expected_end_date;
    private LocalDate actual_end_date;
    private LocalDateTime created_at;
    private String created_by;
    private LocalDateTime last_modified_at;
    private String last_modified_by;
}
