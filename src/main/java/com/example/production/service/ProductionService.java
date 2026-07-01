package com.example.production.service;

import com.example.production.dto.ProductionOrdersDto;

import java.util.List;

public interface ProductionService {

    ProductionOrdersDto createProductionOrdersDto(ProductionOrdersDto productionOrdersDto);
    ProductionOrderResponse getProductionOrdersDtoById(int id);
    List<ProductionOrdersDto> getAllProductionOrdersDto();
    ProductionOrdersDto updateProductionOrdersDto(int id, ProductionOrdersDto productionOrdersDto);
    String deleteProductionOrdersDto(int id);
}
