package com.example.ProductionModule.entity;

import com.example.PlantsCarModule.entity.CarModel;
import com.example.PlantsCarModule.entity.ManufacturingPlant;
import com.example.ProductionModule.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="productionorders",schema = "public")
@Data
public class ProductionOrders {
    @Id
    private int id;
    private String order_number;
    //foreignkey
    private ManufacturingPlant manufacturingPlant;
    //foreignkey
    private CarModel carModel;
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    @Column(nullable = false)
    private int target_quantity;
    private int completed_quantity;
    private LocalDate expected_end_date;
    private LocalDate actual_end_date;
    @CreationTimestamp
    private LocalDateTime created_at;
    private String created_by;
    @UpdateTimestamp
    private LocalDateTime last_modified_at;
    private String last_modified_by;
}
