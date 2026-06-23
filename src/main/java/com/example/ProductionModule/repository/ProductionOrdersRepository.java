package com.example.ProductionModule.repository;

import com.example.ProductionModule.entity.ProductionOrders;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
@Transactional
public interface ProductionOrdersRepository extends JpaRepository<ProductionOrders,Integer> {
}
