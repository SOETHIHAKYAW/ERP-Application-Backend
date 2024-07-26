package com.example.purchasingbackend.controller.sales;

import com.example.purchasingbackend.entity.sales.Opportunity;
import com.example.purchasingbackend.service.sales.OpportunityService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Opportunities.
 */
@RestController
@RequestMapping("/api/opportunities")
@Validated
public class OpportunityController {

    private static final Logger logger = LoggerFactory.getLogger(OpportunityController.class);

    @Autowired
    private OpportunityService opportunityService;

    @PostMapping
    public ResponseEntity<Opportunity> createOpportunity(@Valid @RequestBody Opportunity opportunity) {
        logger.info("Creating new Opportunity: {}", opportunity);
        Opportunity createdOpportunity = opportunityService.createOpportunity(opportunity);
        return ResponseEntity.ok(createdOpportunity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Opportunity> getOpportunityById(@PathVariable Long id) {
        logger.info("Fetching Opportunity with ID: {}", id);
        Opportunity opportunity = opportunityService.getOpportunityById(id);
        if (opportunity != null) {
            return ResponseEntity.ok(opportunity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Opportunity>> getAllOpportunities() {
        logger.info("Fetching all Opportunities");
        List<Opportunity> opportunities = opportunityService.getAllOpportunities();
        return ResponseEntity.ok(opportunities);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Opportunity> updateOpportunity(
            @PathVariable Long id,
            @Valid @RequestBody Opportunity opportunity) {
        logger.info("Updating Opportunity with ID: {}", id);
        opportunity.setId(id);  // Ensure the ID is set for the update
        Opportunity updatedOpportunity = opportunityService.updateOpportunity(opportunity);
        if (updatedOpportunity != null) {
            return ResponseEntity.ok(updatedOpportunity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpportunity(@PathVariable Long id) {
        logger.info("Deleting Opportunity with ID: {}", id);
        opportunityService.deleteOpportunity(id);
        return ResponseEntity.noContent().build();
    }
}
