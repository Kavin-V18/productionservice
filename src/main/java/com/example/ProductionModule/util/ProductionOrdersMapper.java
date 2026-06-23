package com.example.ProductionModule.util;

import com.example.ProductionModule.dto.ProductionOrdersDto;
import com.example.ProductionModule.entity.ProductionOrders;
import org.springframework.stereotype.Component;

@Component
public class ProductionOrdersMapper {

     public ProductionOrdersDto toDto(ProductionOrders productionOrders){
         if (productionOrders == null) return null;

         return ProductionOrdersDto.builder().id(productionOrders.getId()).
         status(productionOrders.getStatus())
                 .order_number(productionOrders.getOrder_number()).
                 target_quantity(productionOrders.getTarget_quantity()).
                 actual_end_date(productionOrders.getActual_end_date()).
                 expected_end_date(productionOrders.getExpected_end_date()).
                 completed_quantity(productionOrders.getCompleted_quantity()).
                 created_at(productionOrders.getCreated_at()).
                 created_by(productionOrders.getCreated_by()).
                 last_modified_at(productionOrders.getLast_modified_at()).
                 last_modified_by(productionOrders.getLast_modified_by()).
                 carModel(productionOrders.getCarModel()).
                 manufacturingPlant(productionOrders.getManufacturingPlant()).build();
     }
    public ProductionOrders toEntity(ProductionOrdersDto dto) {
        if (dto == null) return null;
        ProductionOrders productionOrders = new ProductionOrders();
        productionOrders.setId(dto.getId());
        productionOrders.setOrder_number(dto.getOrder_number());
        productionOrders.setStatus(dto.getStatus());
        productionOrders.setCompleted_quantity(dto.getCompleted_quantity());
        productionOrders.setTarget_quantity(dto.getTarget_quantity());
        productionOrders.setActual_end_date(dto.getActual_end_date());
        productionOrders.setExpected_end_date(dto.getExpected_end_date());
        productionOrders.setLast_modified_by(dto.getLast_modified_by());
        productionOrders.setCreated_by(dto.getCreated_by());
        return productionOrders;
    }
}
