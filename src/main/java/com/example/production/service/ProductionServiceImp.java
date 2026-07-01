package com.example.production.service;

import com.example.production.client.CarPlantClient;
import com.example.production.dto.CarModelDto;
import com.example.production.dto.ManufacturingPlantDto;
import com.example.production.dto.ProductionOrdersDto;
import com.example.production.entity.ProductionOrders;
import com.example.production.repository.ProductionOrdersRepository;
import com.example.production.util.ProductionOrdersMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionServiceImp implements  ProductionService{
     private final ProductionOrdersMapper productionOrdersMapper;
     private final ProductionOrdersRepository productionOrdersRepository;
     private final CarPlantClient carPlantClient;
    @Override
    public ProductionOrdersDto createProductionOrdersDto(ProductionOrdersDto dto) {
        Boolean plantExists = carPlantClient.checkManufacturingPlantExists(dto.getManufacturingPlant()).getBody();
        if (Boolean.FALSE.equals(plantExists)) {
            throw new EntityNotFoundException("Manufacturing Plant not found with id : " + dto.getManufacturingPlant());
        }
        Boolean modelExists = carPlantClient.checkCarModelExists(dto.getCarModel()).getBody();
        if (Boolean.FALSE.equals(modelExists)) {
            throw new EntityNotFoundException("Car Model not found with id : " + dto.getCarModel());
        }
        ProductionOrders entity = productionOrdersMapper.toEntity(dto);
        ProductionOrders saved = productionOrdersRepository.save(entity);
        return productionOrdersMapper.toDto(saved);
    }
    @Override
    public ProductionOrderResponse getProductionOrdersDtoById(int id) {
        ProductionOrders order = productionOrdersRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not Found"));
        ManufacturingPlantDto plant = carPlantClient.getManufacturingPlantById(order.getManufacturingPlant()).getBody();
        CarModelDto model = carPlantClient.getCarModelById(order.getCarModel()).getBody();
        ProductionOrderResponse response = new ProductionOrderResponse();
        response.setProductionOrder(productionOrdersMapper.toDto(order));
        response.setManufacturingPlant(plant);
        response.setCarModel(model);
        return response;
    }
    @Override
    public List<ProductionOrdersDto> getAllProductionOrdersDto() {
        return productionOrdersRepository.findAll().stream().map(productionOrdersMapper::toDto).toList();
    }
    @Override
    public ProductionOrdersDto updateProductionOrdersDto(int id, ProductionOrdersDto productionOrdersDto) {
        Boolean plantExists = carPlantClient.checkManufacturingPlantExists(productionOrdersDto.getManufacturingPlant()).getBody();
        if (Boolean.FALSE.equals(plantExists)) {
            throw new EntityNotFoundException("Plant not found");
        }
        Boolean modelExists = carPlantClient.checkCarModelExists(productionOrdersDto.getCarModel()).getBody();
        if (Boolean.FALSE.equals(modelExists)) {
            throw new EntityNotFoundException("Car Model not found");
        }
        ProductionOrders existing=productionOrdersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        existing.setCreatedBy(productionOrdersDto.getCreatedBy());
        existing.setLastModifiedBy(productionOrdersDto.getLastModifiedBy());
        existing.setStatus(productionOrdersDto.getStatus());
        existing.setOrderNumber(productionOrdersDto.getOrderNumber());
        existing.setActualEndDate(productionOrdersDto.getActualEndDate());
        existing.setExpectedEndDate(productionOrdersDto.getExpectedEndDate());
        existing.setCompletedQuantity(productionOrdersDto.getCompletedQuantity());
        existing.setTargetQuantity(productionOrdersDto.getTargetQuantity());
                ProductionOrders updatedEntity=productionOrdersRepository.save(existing);
        return  productionOrdersMapper.toDto(updatedEntity);
    }
    @Override
    public String deleteProductionOrdersDto(int id) {
        productionOrdersRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        productionOrdersRepository.deleteById(id);
        return "deleted successfully";
    }

}
