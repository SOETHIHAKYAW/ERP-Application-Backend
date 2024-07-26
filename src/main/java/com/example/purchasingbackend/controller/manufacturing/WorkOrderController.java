package com.example.purchasingbackend.controller.manufacturing;

import com.example.purchasingbackend.entity.manufacturing.WorkOrder;
import com.example.purchasingbackend.service.manufacturing.WorkOrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Work Orders.
 */
@RestController
@RequestMapping("/api/work-orders")
@Validated
public class WorkOrderController {

    private static final Logger logger = LoggerFactory.getLogger(WorkOrderController.class);

    @Autowired
    private WorkOrderService workOrderService;

    @PostMapping
    public ResponseEntity<WorkOrder> createWorkOrder(@Valid @RequestBody WorkOrder workOrder) {
        logger.info("Creating new Work Order: {}", workOrder);
        WorkOrder createdWorkOrder = workOrderService.createWorkOrder(workOrder);
        return ResponseEntity.ok(createdWorkOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrder> getWorkOrderById(@PathVariable Long id) {
        logger.info("Fetching Work Order with ID: {}", id);
        WorkOrder workOrder = workOrderService.getWorkOrderById(id);
        if (workOrder != null) {
            return ResponseEntity.ok(workOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<WorkOrder>> getAllWorkOrders() {
        logger.info("Fetching all Work Orders");
        List<WorkOrder> workOrders = workOrderService.getAllWorkOrders();
        return ResponseEntity.ok(workOrders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkOrder> updateWorkOrder(
            @PathVariable Long id,
            @Valid @RequestBody WorkOrder workOrder) {
        logger.info("Updating Work Order with ID: {}", id);
        workOrder.setId(id);  // Ensure the ID is set for the update
        WorkOrder updatedWorkOrder = workOrderService.updateWorkOrder(workOrder);
        if (updatedWorkOrder != null) {
            return ResponseEntity.ok(updatedWorkOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkOrder(@PathVariable Long id) {
        logger.info("Deleting Work Order with ID: {}", id);
        workOrderService.deleteWorkOrder(id);
        return ResponseEntity.noContent().build();
    }
}
