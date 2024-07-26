package com.example.purchasingbackend.service.purchase.impl;

import com.example.purchasingbackend.entity.purchase.PurchaseRequisition;
import com.example.purchasingbackend.repository.purchase.PurchaseRequisitionRepository;
import com.example.purchasingbackend.service.purchase.PurchaseRequisitionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of the PurchaseRequisitionService interface.
 */
@Service
@Validated
public class PurchaseRequisitionServiceImpl implements PurchaseRequisitionService {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseRequisitionServiceImpl.class);

    @Autowired
    private PurchaseRequisitionRepository repository;

    @Override
    public PurchaseRequisition createPurchaseRequisition(@Valid PurchaseRequisition requisition) {
        logger.info("Creating new Purchase Requisition: {}", requisition);
        return repository.save(requisition);
    }

    @Override
    public PurchaseRequisition getPurchaseRequisitionById(Long id) {
        logger.info("Fetching Purchase Requisition with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PurchaseRequisition> getAllPurchaseRequisitions() {
        logger.info("Fetching all Purchase Requisitions");
        return repository.findAll();
    }

    @Override
    public PurchaseRequisition updatePurchaseRequisition(@Valid PurchaseRequisition requisition) {
        logger.info("Updating Purchase Requisition: {}", requisition);
        return repository.save(requisition);
    }

    @Override
    public void deletePurchaseRequisition(Long id) {
        logger.info("Deleting Purchase Requisition with ID: {}", id);
        repository.deleteById(id);
    }
}
