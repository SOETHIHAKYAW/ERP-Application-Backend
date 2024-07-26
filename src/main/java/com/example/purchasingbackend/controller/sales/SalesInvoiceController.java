package com.example.purchasingbackend.controller.sales;

import com.example.purchasingbackend.entity.sales.SalesInvoice;
import com.example.purchasingbackend.service.sales.SalesInvoiceService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Sales Invoices.
 */
@RestController
@RequestMapping("/api/sales-invoices")
@Validated
public class SalesInvoiceController {

    private static final Logger logger = LoggerFactory.getLogger(SalesInvoiceController.class);

    @Autowired
    private SalesInvoiceService salesInvoiceService;

    /**
     * Create a new Sales Invoice.
     *
     * @param invoice SalesInvoice to be created
     * @return ResponseEntity with the created SalesInvoice
     */
    @PostMapping
    public ResponseEntity<SalesInvoice> createInvoice(@Valid @RequestBody SalesInvoice invoice) {
        logger.info("Creating new Sales Invoice: {}", invoice);
        SalesInvoice createdInvoice = salesInvoiceService.createSalesInvoice(invoice);
        return ResponseEntity.ok(createdInvoice);
    }

    /**
     * Get a Sales Invoice by its ID.
     *
     * @param id ID of the SalesInvoice to be fetched
     * @return ResponseEntity with the fetched SalesInvoice or 404 if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<SalesInvoice> getInvoiceById(@PathVariable Long id) {
        logger.info("Fetching Sales Invoice with ID: {}", id);
        SalesInvoice invoice = salesInvoiceService.getSalesInvoiceById(id);
        if (invoice != null) {
            return ResponseEntity.ok(invoice);
        } else {
            logger.warn("Sales Invoice with ID {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get all Sales Invoices.
     *
     * @return ResponseEntity with a list of all SalesInvoices
     */
    @GetMapping
    public ResponseEntity<List<SalesInvoice>> getAllInvoices() {
        logger.info("Fetching all Sales Invoices");
        List<SalesInvoice> invoices = salesInvoiceService.getAllSalesInvoices();
        return ResponseEntity.ok(invoices);
    }

    /**
     * Update a Sales Invoice by its ID.
     *
     * @param id      ID of the SalesInvoice to be updated
     * @param invoice SalesInvoice with updated information
     * @return ResponseEntity with the updated SalesInvoice or 404 if not found
     */
    @PutMapping("/{id}")
    public ResponseEntity<SalesInvoice> updateInvoice(
            @PathVariable Long id,
            @Valid @RequestBody SalesInvoice invoice) {
        logger.info("Updating Sales Invoice with ID: {}", id);
        invoice.setId(id);  // Ensure the ID is set for the update
        SalesInvoice updatedInvoice = salesInvoiceService.updateSalesInvoice(invoice);
        if (updatedInvoice != null) {
            return ResponseEntity.ok(updatedInvoice);
        } else {
            logger.warn("Sales Invoice with ID {} not found for update", id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a Sales Invoice by its ID.
     *
     * @param id ID of the SalesInvoice to be deleted
     * @return ResponseEntity with status of the operation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        logger.info("Deleting Sales Invoice with ID: {}", id);
        try {
            salesInvoiceService.deleteSalesInvoice(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting Sales Invoice with ID {}: {}", id, e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
