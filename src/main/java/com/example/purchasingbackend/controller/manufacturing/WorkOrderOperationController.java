package com.example.purchasingbackend.controller.manufacturing;

import com.example.purchasingbackend.entity.manufacturing.WorkOrderOperation;
import com.example.purchasingbackend.service.manufacturing.WorkOrderOperationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Work Order Operations.
 */
@RestController
@RequestMapping("/api/work-order-operations")
@Validated
public class WorkOrderOperationController {

    private static final Logger logger = LoggerFactory.getLogger(WorkOrderOperationController.class);

    @Autowired
    private WorkOrderOperationService workOrderOperationService;

    @PostMapping
    public ResponseEntity<WorkOrderOperation> createWorkOrderOperation(@Valid @RequestBody WorkOrderOperation workOrderOperation) {
        logger.info("Creating new Work Order Operation: {}", workOrderOperation);
        WorkOrderOperation createdWorkOrderOperation = workOrderOperationService.createWorkOrderOperation(workOrderOperation);
        return ResponseEntity.ok(createdWorkOrderOperation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkOrderOperation> getWorkOrderOperationById(@PathVariable Long id) {
        logger.info("Fetching Work Order Operation with ID: {}", id);
        WorkOrderOperation workOrderOperation = workOrderOperationService.getWorkOrderOperationById(id);
        if (workOrderOperation != null) {
            return ResponseEntity.ok(workOrderOperation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<WorkOrderOperation>> getAllWorkOrderOperations() {
        logger.info("Fetching all Work Order Operations");
        List<WorkOrderOperation> workOrderOperations = workOrderOperationService.getAllWorkOrderOperations();
        return ResponseEntity.ok(workOrderOperations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkOrderOperation> updateWorkOrderOperation(
            @PathVariable Long id,
            @Valid @RequestBody WorkOrderOperation workOrderOperation) {
        logger.info("Updating Work Order Operation with ID: {}", id);
        workOrderOperation.setId(id);  // Ensure the ID is set for the update
        WorkOrderOperation updatedWorkOrderOperation = workOrderOperationService.updateWorkOrderOperation(workOrderOperation);
        if (updatedWorkOrderOperation != null) {
            return ResponseEntity.ok(updatedWorkOrderOperation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkOrderOperation(@PathVariable Long id) {
        logger.info("Deleting Work Order Operation with ID: {}", id);
        workOrderOperationService.deleteWorkOrderOperation(id);
        return ResponseEntity.noContent().build();
    }
}
