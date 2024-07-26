package com.example.purchasingbackend.service.accounting.impl;

import com.example.purchasingbackend.entity.accounting.Invoice;
import com.example.purchasingbackend.repository.accounting.InvoiceRepository;
import com.example.purchasingbackend.service.accounting.InvoiceService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of InvoiceService interface.
 */
@Service
@Validated
public class InvoiceServiceImpl implements InvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

    @Autowired
    private InvoiceRepository repository;

    @Override
    public Invoice createInvoice(@Valid Invoice invoice) {
        logger.info("Creating new Invoice: {}", invoice);
        return repository.save(invoice);
    }

    @Override
    public Invoice getInvoiceById(Long id) {
        logger.info("Fetching Invoice with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        logger.info("Fetching all Invoices");
        return repository.findAll();
    }

    @Override
    public Invoice updateInvoice(@Valid Invoice invoice) {
        logger.info("Updating Invoice: {}", invoice);
        return repository.save(invoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        logger.info("Deleting Invoice with ID: {}", id);
        repository.deleteById(id);
    }
}
