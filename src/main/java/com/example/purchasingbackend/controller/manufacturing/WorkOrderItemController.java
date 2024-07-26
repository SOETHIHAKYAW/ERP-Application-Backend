package com.example.purchasingbackend.controller.manufacturing;

import com.example.purchasingbackend.entity.manufacturing.WorkOrderItem;
import com.example.purchasingbackend.service.manufacturing.WorkOrderItemService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Work Order Items.
 */
@RestController
@RequestMapping("/api/work-order-items")
@Validated
public class WorkOrderItemController {

    private static final Logger logger = LoggerFactory.getLogger(WorkOrderItemController.class);

    @Autowired
    private WorkOrderItemService workOrderItemService;

    @PostMapping
    public ResponseEntity<WorkOrderItem> createWorkOrderItem(@Valid @RequestBody WorkOrderItem workOrderItem) {
        logger.info("Creating new Work Order Item: {}", workOrderItem);
        WorkOrderItem createdWorkOrderItem = workOrderItemService.createWorkOrderItem(workOrderItem);
        return ResponseEntity.ok(createdWorkOrderItem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrderItem> getWorkOrderItemById(@PathVariable Long id) {
        logger.info("Fetching Work Order Item with ID: {}", id);
        WorkOrderItem workOrderItem = workOrderItemService.getWorkOrderItemById(id);
        if (workOrderItem != null) {
            return ResponseEntity.ok(workOrderItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<WorkOrderItem>> getAllWorkOrderItems() {
        logger.info("Fetching all Work Order Items");
        List<WorkOrderItem> workOrderItems = workOrderItemService.getAllWorkOrderItems();
        return ResponseEntity.ok(workOrderItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkOrderItem> updateWorkOrderItem(
            @PathVariable Long id,
            @Valid @RequestBody WorkOrderItem workOrderItem) {
        logger.info("Updating Work Order Item with ID: {}", id);
        workOrderItem.setId(id);  // Ensure the ID is set for the update
        WorkOrderItem updatedWorkOrderItem = workOrderItemService.updateWorkOrderItem(workOrderItem);
        if (updatedWorkOrderItem != null) {
            return ResponseEntity.ok(updatedWorkOrderItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkOrderItem(@PathVariable Long id) {
        logger.info("Deleting Work Order Item with ID: {}", id);
        workOrderItemService.deleteWorkOrderItem(id);
        return ResponseEntity.noContent().build();
    }
}
