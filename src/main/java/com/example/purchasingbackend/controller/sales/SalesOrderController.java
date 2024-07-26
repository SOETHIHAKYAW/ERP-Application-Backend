package com.example.purchasingbackend.controller.sales;

import com.example.purchasingbackend.entity.sales.SalesOrder;
import com.example.purchasingbackend.service.sales.SalesOrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Sales Orders.
 */
@RestController
@RequestMapping("/api/sales-orders")
@Validated
public class SalesOrderController {

    private static final Logger logger = LoggerFactory.getLogger(SalesOrderController.class);

    @Autowired
    private SalesOrderService salesOrderService;

    /**
     * Create a new Sales Order.
     *
     * @param order SalesOrder to be created
     * @return ResponseEntity with the created SalesOrder
     */
    @PostMapping
    public ResponseEntity<SalesOrder> createOrder(@Valid @RequestBody SalesOrder order) {
        logger.info("Creating new Sales Order: {}", order);
        SalesOrder createdOrder = salesOrderService.createSalesOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    /**
     * Get a Sales Order by its ID.
     *
     * @param id ID of the SalesOrder to be fetched
     * @return ResponseEntity with the fetched SalesOrder or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<SalesOrder> getOrderById(@PathVariable Long id) {
        logger.info("Fetching Sales Order with ID: {}", id);
        SalesOrder order = salesOrderService.getSalesOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            logger.warn("Sales Order with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get all Sales Orders.
     *
     * @return ResponseEntity with a list of all SalesOrders
     */
    @GetMapping
    public ResponseEntity<List<SalesOrder>> getAllOrders() {
        logger.info("Fetching all Sales Orders");
        List<SalesOrder> orders = salesOrderService.getAllSalesOrders();
        return ResponseEntity.ok(orders);
    }

    /**
     * Update a Sales Order by its ID.
     *
     * @param id    ID of the SalesOrder to be updated
     * @param order SalesOrder with updated information
     * @return ResponseEntity with the updated SalesOrder or 404 if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<SalesOrder> updateOrder(
            @PathVariable Long id,
            @Valid @RequestBody SalesOrder order) {
        logger.info("Updating Sales Order with ID: {}", id);
        order.setId(id);  // Ensure the ID is set for the update
        SalesOrder updatedOrder = salesOrderService.updateSalesOrder(order);
        if (updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else {
            logger.warn("Sales Order with ID {} not found for update", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a Sales Order by its ID.
     *
     * @param id ID of the SalesOrder to be deleted
     * @return ResponseEntity with status of the operation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        logger.info("Deleting Sales Order with ID: {}", id);
        try {
            salesOrderService.deleteSalesOrder(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting Sales Order with ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
