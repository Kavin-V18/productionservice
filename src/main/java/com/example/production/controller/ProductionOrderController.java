package com.example.production.controller;

import com.example.production.dto.ProductionOrdersDto;
import com.example.production.service.ProductionService;
import com.example.production.service.ProductionOrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class ProductionOrderController {
    private final ProductionService productionService;

    @GetMapping()
    public List<ProductionOrdersDto> getProductionOrders() {
        return productionService.getAllProductionOrdersDto();
    }
    @PostMapping()
    public  String createProductionOrders(@Valid @RequestBody ProductionOrdersDto productionOrdersDto){
        productionService.createProductionOrdersDto(productionOrdersDto);
        return  "user Created Successfully";
    }
    @GetMapping("/{id}")
    public ProductionOrderResponse getProductionOrdersById(@PathVariable int id){
        return productionService.getProductionOrdersDtoById(id);
    }
    @PostMapping("/{id}")
    public ProductionOrdersDto updateProductionOrders(@PathVariable int id,@Valid @RequestBody ProductionOrdersDto productionOrdersDto){
        return  productionService.updateProductionOrdersDto(id, productionOrdersDto);
    }
    @DeleteMapping("/{id}")
    public String deleteProductionOrders(@PathVariable int id){
        return productionService.deleteProductionOrdersDto(id);
    }
}
