package com.example.purchasingbackend.repository.manufacturing;

import com.example.purchasingbackend.entity.manufacturing.WorkOrderOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for managing WorkOrderOperation entities.
 */
@Repository
public interface WorkOrderOperationRepository extends JpaRepository<WorkOrderOperation, Long> {
}
