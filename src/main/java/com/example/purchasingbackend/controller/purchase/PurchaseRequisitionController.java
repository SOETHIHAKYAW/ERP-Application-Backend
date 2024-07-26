package com.example.purchasingbackend.controller.purchase;

import com.example.purchasingbackend.entity.purchase.PurchaseRequisition;
import com.example.purchasingbackend.service.purchase.PurchaseRequisitionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Purchase Requisitions.
 */
@RestController
@RequestMapping("/api/purchase-requisitions")
@Validated
public class PurchaseRequisitionController {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseRequisitionController.class);

    @Autowired
    private PurchaseRequisitionService purchaseRequisitionService;

    @PostMapping
    public ResponseEntity<PurchaseRequisition> createPurchaseRequisition(@Valid @RequestBody PurchaseRequisition purchaseRequisition) {
        logger.info("Creating Purchase Requisition: {}", purchaseRequisition);
        PurchaseRequisition createdRequisition = purchaseRequisitionService.createPurchaseRequisition(purchaseRequisition);
        return ResponseEntity.ok(createdRequisition);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseRequisition> getPurchaseRequisitionById(@PathVariable Long id) {
        logger.info("Fetching Purchase Requisition with ID: {}", id);
        PurchaseRequisition requisition = purchaseRequisitionService.getPurchaseRequisitionById(id);
        if (requisition != null) {
            return ResponseEntity.ok(requisition);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PurchaseRequisition>> getAllPurchaseRequisitions() {
        logger.info("Fetching all Purchase Requisitions");
        List<PurchaseRequisition> requisitions = purchaseRequisitionService.getAllPurchaseRequisitions();
        return ResponseEntity.ok(requisitions);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseRequisition> updatePurchaseRequisition(
            @PathVariable Long id,
            @Valid @RequestBody PurchaseRequisition purchaseRequisition) {
        logger.info("Updating Purchase Requisition with ID: {}", id);
        purchaseRequisition.setId(id);  // Ensure the ID is set for the update
        PurchaseRequisition updatedRequisition = purchaseRequisitionService.updatePurchaseRequisition(purchaseRequisition);
        return ResponseEntity.ok(updatedRequisition);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseRequisition(@PathVariable Long id) {
        logger.info("Deleting Purchase Requisition with ID: {}", id);
        purchaseRequisitionService.deletePurchaseRequisition(id);
        return ResponseEntity.noContent().build();
    }
}
