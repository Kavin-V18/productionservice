package com.example.production.repository;

import com.example.production.entity.ProductionOrders;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ProductionOrdersRepository extends JpaRepository<ProductionOrders,Integer> {
}
