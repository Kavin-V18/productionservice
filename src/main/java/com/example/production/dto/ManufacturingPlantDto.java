package com.example.production.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ManufacturingPlantDto {
    private String name;
    private String code;
    private String location;
    @Min(1)
    private int capacityPerDay;
    @ColumnDefault("true")
    private boolean isActive;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private Long createdBy;
    @NotNull
    private LocalDateTime lastModifiedAt;
    @NotNull
    private Long lastModifiedBy;
}
