package com.example.purchasingbackend.service.sales.impl;

import com.example.purchasingbackend.entity.sales.Quotation;
import com.example.purchasingbackend.repository.sales.QuotationRepository;
import com.example.purchasingbackend.service.sales.QuotationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of the QuotationService interface.
 */
@Service
@Validated
public class QuotationServiceImpl implements QuotationService {

    private static final Logger logger = LoggerFactory.getLogger(QuotationServiceImpl.class);

    @Autowired
    private QuotationRepository repository;

    @Override
    public Quotation createQuotation(@Valid Quotation quotation) {
        logger.info("Creating new Quotation: {}", quotation);
        return repository.save(quotation);
    }

    @Override
    public Quotation getQuotationById(Long id) {
        logger.info("Fetching Quotation with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Quotation> getAllQuotations() {
        logger.info("Fetching all Quotations");
        return repository.findAll();
    }

    @Override
    public Quotation updateQuotation(@Valid Quotation quotation) {
        logger.info("Updating Quotation: {}", quotation);
        return repository.save(quotation);
    }

    @Override
    public void deleteQuotation(Long id) {
        logger.info("Deleting Quotation with ID: {}", id);
        repository.deleteById(id);
    }
}
