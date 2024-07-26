package com.example.purchasingbackend.repository.manufacturing;

import com.example.purchasingbackend.entity.manufacturing.WorkOrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderItemRepository extends JpaRepository<WorkOrderItem, Long> {
}
