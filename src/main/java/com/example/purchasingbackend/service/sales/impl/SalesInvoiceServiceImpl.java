package com.example.purchasingbackend.service.sales.impl;

import com.example.purchasingbackend.entity.sales.SalesInvoice;
import com.example.purchasingbackend.repository.sales.SalesInvoiceRepository;
import com.example.purchasingbackend.service.sales.SalesInvoiceService;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of SalesInvoiceService interface.
 */
@Service
public class SalesInvoiceServiceImpl implements SalesInvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(SalesInvoiceServiceImpl.class);

    @Autowired
    private SalesInvoiceRepository salesInvoiceRepository;

    @Override
    public SalesInvoice createSalesInvoice(SalesInvoice invoice) {
        logger.info("Creating Sales Invoice: {}", invoice);
        // Perform validation checks here if needed
        validateInvoice(invoice);
        SalesInvoice createdInvoice = salesInvoiceRepository.save(invoice);
        logger.info("Created Sales Invoice: {}", createdInvoice);
        return createdInvoice;
    }

    @Override
    public SalesInvoice getSalesInvoiceById(Long id) {
        logger.info("Fetching Sales Invoice with ID: {}", id);
        Optional<SalesInvoice> invoice = salesInvoiceRepository.findById(id);
        if (invoice.isPresent()) {
            logger.info("Found Sales Invoice: {}", invoice.get());
            return invoice.get();
        } else {
            logger.warn("Sales Invoice with ID {} not found", id);
            return null;
        }
    }

    @Override
    public List<SalesInvoice> getAllSalesInvoices() {
        logger.info("Fetching all Sales Invoices");
        List<SalesInvoice> invoices = salesInvoiceRepository.findAll();
        logger.info("Found {} Sales Invoices", invoices.size());
        return invoices;
    }

    @Override
    public SalesInvoice updateSalesInvoice(SalesInvoice invoice) {
        logger.info("Updating Sales Invoice: {}", invoice);
        if (invoice.getId() == null || !salesInvoiceRepository.existsById(invoice.getId())) {
            logger.warn("Sales Invoice with ID {} does not exist for update", invoice.getId());
            throw new ValidationException("Invoice not found for update");
        }
        SalesInvoice updatedInvoice = salesInvoiceRepository.save(invoice);
        logger.info("Updated Sales Invoice: {}", updatedInvoice);
        return updatedInvoice;
    }

    @Override
    public void deleteSalesInvoice(Long id) {
        logger.info("Deleting Sales Invoice with ID: {}", id);
        if (!salesInvoiceRepository.existsById(id)) {
            logger.warn("Sales Invoice with ID {} does not exist for deletion", id);
            throw new ValidationException("Invoice not found for deletion");
        }
        salesInvoiceRepository.deleteById(id);
        logger.info("Deleted Sales Invoice with ID: {}", id);
    }

    /**
     * Validate the Sales Invoice entity.
     *
     * @param invoice SalesInvoice entity to validate
     */
    private void validateInvoice(SalesInvoice invoice) {
        // Add validation logic as per your requirements
        if (invoice == null) {
            throw new ValidationException("Invoice cannot be null");
        }
        // Example: Validate required fields
        if (invoice.getTotalAmount() == null || invoice.getTotalAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Invoice amount must be greater than zero");
        }
        // Additional validation rules can be added here
    }
}
