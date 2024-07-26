package com.example.purchasingbackend.controller.sales;

import com.example.purchasingbackend.entity.sales.Lead;
import com.example.purchasingbackend.service.sales.LeadService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Leads.
 */
@RestController
@RequestMapping("/api/leads")
@Validated
public class LeadController {

    private static final Logger logger = LoggerFactory.getLogger(LeadController.class);

    @Autowired
    private LeadService leadService;

    @PostMapping
    public ResponseEntity<Lead> createLead(@Valid @RequestBody Lead lead) {
        logger.info("Creating new Lead: {}", lead);
        Lead createdLead = leadService.createLead(lead);
        return ResponseEntity.ok(createdLead);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable Long id) {
        logger.info("Fetching Lead with ID: {}", id);
        Lead lead = leadService.getLeadById(id);
        if (lead != null) {
            return ResponseEntity.ok(lead);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Lead>> getAllLeads() {
        logger.info("Fetching all Leads");
        List<Lead> leads = leadService.getAllLeads();
        return ResponseEntity.ok(leads);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(
            @PathVariable Long id,
            @Valid @RequestBody Lead lead) {
        logger.info("Updating Lead with ID: {}", id);
        lead.setId(id);  // Ensure the ID is set for the update
        Lead updatedLead = leadService.updateLead(lead);
        if (updatedLead != null) {
            return ResponseEntity.ok(updatedLead);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        logger.info("Deleting Lead with ID: {}", id);
        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }
}
