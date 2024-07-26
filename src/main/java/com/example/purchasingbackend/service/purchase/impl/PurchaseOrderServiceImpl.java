package com.example.purchasingbackend.service.purchase.impl;

import com.example.purchasingbackend.entity.purchase.PurchaseOrder;
import com.example.purchasingbackend.repository.purchase.PurchaseOrderRepository;
import com.example.purchasingbackend.service.purchase.PurchaseOrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of the PurchaseOrderService interface.
 */
@Service
@Validated
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderServiceImpl.class);

    @Autowired
    private PurchaseOrderRepository repository;

    @Override
    public PurchaseOrder createPurchaseOrder(@Valid PurchaseOrder purchaseOrder) {
        logger.info("Creating new Purchase Order: {}", purchaseOrder);
        return repository.save(purchaseOrder);
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        logger.info("Fetching Purchase Order with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        logger.info("Fetching all Purchase Orders");
        return repository.findAll();
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(@Valid PurchaseOrder purchaseOrder) {
        logger.info("Updating Purchase Order: {}", purchaseOrder);
        return repository.save(purchaseOrder);
    }

    @Override
    public void deletePurchaseOrder(Long id) {
        logger.info("Deleting Purchase Order with ID: {}", id);
        repository.deleteById(id);
    }
}
