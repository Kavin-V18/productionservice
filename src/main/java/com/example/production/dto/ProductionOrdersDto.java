package com.example.production.dto;

import com.example.production.Status;
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

    private String orderNumber;
    //foreignkey--manufacturing plant
    private Long manufacturingPlant;
    //foreignkey-car model
    private Long carModel;
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    @Column(nullable = false)
    @Min(1)
    private int targetQuantity;
    @Min(0)
    private int completedQuantity;
    private LocalDate expectedEndDate;
    private LocalDateTime actualEndDate;
    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime lastModifiedAt;
    private Long lastModifiedBy;
    private boolean deleted;
}
