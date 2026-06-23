package com.example.ProductionModule.service;

import com.example.ProductionModule.dto.ProductionOrdersDto;
import com.example.ProductionModule.entity.ProductionOrders;
import com.example.ProductionModule.repository.ProductionOrdersRepository;
import com.example.ProductionModule.util.ProductionOrdersMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImp implements  ProductionService{
     private final ProductionOrdersMapper productionOrdersMapper;
     private final ProductionOrdersRepository productionOrdersRepository;
    public ProductionServiceImp(ProductionOrdersMapper productionOrdersMapper, ProductionOrdersRepository productionOrdersRepository) {
        this.productionOrdersMapper = productionOrdersMapper;
        this.productionOrdersRepository = productionOrdersRepository;
    }
    @Override
    public ProductionOrdersDto createProductionOrdersDto(ProductionOrdersDto productionOrdersDto) {
        ProductionOrders entity = productionOrdersMapper.toEntity(productionOrdersDto); // DTO -> Entity
        ProductionOrders savedEntity = productionOrdersRepository.save(entity);
        return productionOrdersMapper.toDto(savedEntity);
    }
    @Override
    public ProductionOrdersDto getProductionOrdersDtoById(int id) {
        ProductionOrders existing=productionOrdersRepository.findById(id).orElseThrow(()->new EntityNotFoundException("No data present in this id"));
        ProductionOrdersDto productionDtos= productionOrdersMapper.toDto(existing);
        return  productionDtos;
    }
    @Override
    public List<ProductionOrdersDto> getAllProductionOrdersDto() {
        return productionOrdersRepository.findAll().stream().map(productionOrdersMapper::toDto).toList();
    }
    @Override
    public ProductionOrdersDto updateProductionOrdersDto(int id, ProductionOrdersDto productionOrdersDto) {
        ProductionOrders existing=productionOrdersRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        existing.setCreated_by(productionOrdersDto.getCreated_by());
        existing.setLast_modified_by(productionOrdersDto.getLast_modified_by());
        existing.setStatus(productionOrdersDto.getStatus());
        existing.setOrder_number(productionOrdersDto.getOrder_number());
        existing.setActual_end_date(productionOrdersDto.getActual_end_date());
        existing.setExpected_end_date(productionOrdersDto.getExpected_end_date());
        existing.setCompleted_quantity(productionOrdersDto.getCompleted_quantity());
        existing.setTarget_quantity(productionOrdersDto.getTarget_quantity());
        existing.setCreated_by(productionOrdersDto.getCreated_by());
        existing.setLast_modified_by(productionOrdersDto.getLast_modified_by());
                ProductionOrders updatedEntity=productionOrdersRepository.save(existing);
        return  productionOrdersMapper.toDto(updatedEntity);
    }
    @Override
    public String deleteProductionOrdersDto(int id) {
        ProductionOrders existing=productionOrdersRepository.findById(id).orElseThrow(()->new EntityNotFoundException());
        productionOrdersRepository.deleteById(id);
        return "deleted successfully";
    }
}
