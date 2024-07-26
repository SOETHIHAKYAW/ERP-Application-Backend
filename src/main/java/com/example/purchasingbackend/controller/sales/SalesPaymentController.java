package com.example.purchasingbackend.controller.sales;

import com.example.purchasingbackend.entity.sales.SalesPayment;
import com.example.purchasingbackend.service.sales.SalesPaymentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Sales Payments.
 */
@RestController
@RequestMapping("/api/sales-payments")
@Validated
public class SalesPaymentController {

    private static final Logger logger = LoggerFactory.getLogger(SalesPaymentController.class);

    @Autowired
    private SalesPaymentService salesPaymentService;

    /**
     * Create a new Sales Payment.
     *
     * @param payment SalesPayment to be created
     * @return ResponseEntity with the created SalesPayment
     */
    @PostMapping
    public ResponseEntity<SalesPayment> createPayment(@Valid @RequestBody SalesPayment payment) {
        logger.info("Creating new Sales Payment: {}", payment);
        SalesPayment createdPayment = salesPaymentService.createSalesPayment(payment);
        return ResponseEntity.ok(createdPayment);
    }

    /**
     * Get a Sales Payment by its ID.
     *
     * @param id ID of the SalesPayment to be fetched
     * @return ResponseEntity with the fetched SalesPayment or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<SalesPayment> getPaymentById(@PathVariable Long id) {
        logger.info("Fetching Sales Payment with ID: {}", id);
        SalesPayment payment = salesPaymentService.getSalesPaymentById(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            logger.warn("Sales Payment with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get all Sales Payments.
     *
     * @return ResponseEntity with a list of all SalesPayments
     */
    @GetMapping
    public ResponseEntity<List<SalesPayment>> getAllPayments() {
        logger.info("Fetching all Sales Payments");
        List<SalesPayment> payments = salesPaymentService.getAllSalesPayments();
        return ResponseEntity.ok(payments);
    }

    /**
     * Update a Sales Payment by its ID.
     *
     * @param id      ID of the SalesPayment to be updated
     * @param payment SalesPayment with updated information
     * @return ResponseEntity with the updated SalesPayment or 404 if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<SalesPayment> updatePayment(
            @PathVariable Long id,
            @Valid @RequestBody SalesPayment payment) {
        logger.info("Updating Sales Payment with ID: {}", id);
        payment.setId(id);  // Ensure the ID is set for the update
        SalesPayment updatedPayment = salesPaymentService.updateSalesPayment(payment);
        if (updatedPayment != null) {
            return ResponseEntity.ok(updatedPayment);
        } else {
            logger.warn("Sales Payment with ID {} not found for update", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a Sales Payment by its ID.
     *
     * @param id ID of the SalesPayment to be deleted
     * @return ResponseEntity with status of the operation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        logger.info("Deleting Sales Payment with ID: {}", id);
        try {
            salesPaymentService.deleteSalesPayment(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting Sales Payment with ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
