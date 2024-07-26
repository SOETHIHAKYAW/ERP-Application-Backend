package com.example.purchasingbackend.controller.sales;

import com.example.purchasingbackend.entity.sales.Quotation;
import com.example.purchasingbackend.service.sales.QuotationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Quotations.
 */
@RestController
@RequestMapping("/api/quotations")
@Validated
public class QuotationController {

    private static final Logger logger = LoggerFactory.getLogger(QuotationController.class);

    @Autowired
    private QuotationService quotationService;

    @PostMapping
    public ResponseEntity<Quotation> createQuotation(@Valid @RequestBody Quotation quotation) {
        logger.info("Creating new Quotation: {}", quotation);
        Quotation createdQuotation = quotationService.createQuotation(quotation);
        return ResponseEntity.ok(createdQuotation);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quotation> getQuotationById(@PathVariable Long id) {
        logger.info("Fetching Quotation with ID: {}", id);
        Quotation quotation = quotationService.getQuotationById(id);
        if (quotation != null) {
            return ResponseEntity.ok(quotation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Quotation>> getAllQuotations() {
        logger.info("Fetching all Quotations");
        List<Quotation> quotations = quotationService.getAllQuotations();
        return ResponseEntity.ok(quotations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Quotation> updateQuotation(
            @PathVariable Long id,
            @Valid @RequestBody Quotation quotation) {
        logger.info("Updating Quotation with ID: {}", id);
        quotation.setId(id);  // Ensure the ID is set for the update
        Quotation updatedQuotation = quotationService.updateQuotation(quotation);
        if (updatedQuotation != null) {
            return ResponseEntity.ok(updatedQuotation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuotation(@PathVariable Long id) {
        logger.info("Deleting Quotation with ID: {}", id);
        quotationService.deleteQuotation(id);
        return ResponseEntity.noContent().build();
    }
}
