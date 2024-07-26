package com.example.purchasingbackend.service.sales.impl;

import com.example.purchasingbackend.entity.sales.Opportunity;
import com.example.purchasingbackend.repository.sales.OpportunityRepository;
import com.example.purchasingbackend.service.sales.OpportunityService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of the OpportunityService interface.
 */
@Service
@Validated
public class OpportunityServiceImpl implements OpportunityService {

    private static final Logger logger = LoggerFactory.getLogger(OpportunityServiceImpl.class);

    @Autowired
    private OpportunityRepository repository;

    @Override
    public Opportunity createOpportunity(@Valid Opportunity opportunity) {
        logger.info("Creating new Opportunity: {}", opportunity);
        return repository.save(opportunity);
    }

    @Override
    public Opportunity getOpportunityById(Long id) {
        logger.info("Fetching Opportunity with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Opportunity> getAllOpportunities() {
        logger.info("Fetching all Opportunities");
        return repository.findAll();
    }

    @Override
    public Opportunity updateOpportunity(@Valid Opportunity opportunity) {
        logger.info("Updating Opportunity: {}", opportunity);
        return repository.save(opportunity);
    }

    @Override
    public void deleteOpportunity(Long id) {
        logger.info("Deleting Opportunity with ID: {}", id);
        repository.deleteById(id);
    }
}
