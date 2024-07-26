package com.example.purchasingbackend.controller.purchase;

import com.example.purchasingbackend.entity.purchase.PurchaseOrder;
import com.example.purchasingbackend.service.purchase.PurchaseOrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Purchase Orders.
 */
@RestController
@RequestMapping("/api/purchase-orders")
@Validated
public class PurchaseOrderController {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@Valid @RequestBody PurchaseOrder purchaseOrder) {
        logger.info("Creating Purchase Order: {}", purchaseOrder);
        PurchaseOrder createdOrder = purchaseOrderService.createPurchaseOrder(purchaseOrder);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable Long id) {
        logger.info("Fetching Purchase Order with ID: {}", id);
        PurchaseOrder order = purchaseOrderService.getPurchaseOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        logger.info("Fetching all Purchase Orders");
        List<PurchaseOrder> orders = purchaseOrderService.getAllPurchaseOrders();
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(
            @PathVariable Long id,
            @Valid @RequestBody PurchaseOrder purchaseOrder) {
        logger.info("Updating Purchase Order with ID: {}", id);
        purchaseOrder.setId(id);  // Ensure the ID is set for the update
        PurchaseOrder updatedOrder = purchaseOrderService.updatePurchaseOrder(purchaseOrder);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePurchaseOrder(@PathVariable Long id) {
        logger.info("Deleting Purchase Order with ID: {}", id);
        purchaseOrderService.deletePurchaseOrder(id);
        return ResponseEntity.noContent().build();
    }
}
