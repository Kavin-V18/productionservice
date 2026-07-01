package com.example.production.util;

import com.example.production.dto.ProductionOrdersDto;
import com.example.production.entity.ProductionOrders;
import org.springframework.stereotype.Component;

@Component
public class ProductionOrdersMapper {

     public ProductionOrdersDto toDto(ProductionOrders productionOrders){
         if (productionOrders == null) return null;

         return ProductionOrdersDto.builder().
         status(productionOrders.getStatus())
                 .orderNumber(productionOrders.getOrderNumber()).
                 targetQuantity(productionOrders.getTargetQuantity()).
                 actualEndDate(productionOrders.getActualEndDate()).
                 expectedEndDate(productionOrders.getExpectedEndDate()).
                 completedQuantity(productionOrders.getCompletedQuantity()).
                 createdAt(productionOrders.getCreatedAt()).
                 createdBy(productionOrders.getCreatedBy()).
                 lastModifiedAt(productionOrders.getLastModifiedAt()).
                 lastModifiedBy(productionOrders.getLastModifiedBy()).
                 carModel(productionOrders.getCarModel()).
                 manufacturingPlant(productionOrders.getManufacturingPlant()).build();
     }
    public ProductionOrders toEntity(ProductionOrdersDto dto) {
        if (dto == null) return null;
        ProductionOrders productionOrders = new ProductionOrders();
        productionOrders.setOrderNumber(dto.getOrderNumber());
        productionOrders.setStatus(dto.getStatus());
        productionOrders.setCompletedQuantity(dto.getCompletedQuantity());
        productionOrders.setTargetQuantity(dto.getTargetQuantity());
        productionOrders.setActualEndDate(dto.getActualEndDate());
        productionOrders.setExpectedEndDate(dto.getExpectedEndDate());
        productionOrders.setLastModifiedBy(dto.getLastModifiedBy());
        productionOrders.setCreatedBy(dto.getCreatedBy());
        return productionOrders;
    }
}
