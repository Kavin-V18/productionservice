package com.example.ProductionModule.repository;

import com.example.ProductionModule.entity.ProductionOrders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionOrdersRepository extends JpaRepository<ProductionOrders,Integer> {
}
