package com.example.ProductionModule.service;

import com.example.ProductionModule.dto.ProductionOrdersDto;

import java.util.List;

public interface ProductionService {

    ProductionOrdersDto createProductionOrdersDto(ProductionOrdersDto productionOrdersDto);
    ProductionOrdersDto getProductionOrdersDtoById(int id);
    List<ProductionOrdersDto> getAllProductionOrdersDto();
    ProductionOrdersDto updateProductionOrdersDto(int id, ProductionOrdersDto productionOrdersDto);
    String deleteProductionOrdersDto(int id);
}
