package com.example.purchasingbackend.service.sales.impl;

import com.example.purchasingbackend.entity.sales.Lead;
import com.example.purchasingbackend.repository.sales.LeadRepository;
import com.example.purchasingbackend.service.sales.LeadService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of the LeadService interface.
 */
@Service
@Validated
public class LeadServiceImpl implements LeadService {

    private static final Logger logger = LoggerFactory.getLogger(LeadServiceImpl.class);

    @Autowired
    private LeadRepository repository;

    @Override
    public Lead createLead(@Valid Lead lead) {
        logger.info("Creating new Lead: {}", lead);
        return repository.save(lead);
    }

    @Override
    public Lead getLeadById(Long id) {
        logger.info("Fetching Lead with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Lead> getAllLeads() {
        logger.info("Fetching all Leads");
        return repository.findAll();
    }

    @Override
    public Lead updateLead(@Valid Lead lead) {
        logger.info("Updating Lead: {}", lead);
        return repository.save(lead);
    }

    @Override
    public void deleteLead(Long id) {
        logger.info("Deleting Lead with ID: {}", id);
        repository.deleteById(id);
    }
}
