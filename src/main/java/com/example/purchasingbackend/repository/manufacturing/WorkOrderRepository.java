package com.example.purchasingbackend.repository.manufacturing;

import com.example.purchasingbackend.entity.manufacturing.WorkOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderRepository extends JpaRepository<WorkOrder, Long> {
}