package com.example.ProductionModule.entity;

import com.example.PlantsCarModule.entity.CarModel;
import com.example.PlantsCarModule.entity.ManufacturingPlant;
import com.example.ProductionModule.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="productionorders",schema = "public")
@Data
public class ProductionOrders {
    @Id
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
}
