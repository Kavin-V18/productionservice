package com.example.ProductionModule.controller;

import com.example.ProductionModule.dto.ProductionOrdersDto;
import com.example.ProductionModule.service.ProductionService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class ProductionOrderController {
    private final ProductionService productionService;
    public ProductionOrderController(ProductionService productionService){
        this.productionService=productionService;
    }
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
    public ProductionOrdersDto getProductionOrdersById(@PathVariable int id){
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
