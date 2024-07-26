package com.example.purchasingbackend.service.manufacturing.impl;

import com.example.purchasingbackend.entity.manufacturing.WorkOrderItem;
import com.example.purchasingbackend.repository.manufacturing.WorkOrderItemRepository;
import com.example.purchasingbackend.service.manufacturing.WorkOrderItemService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of the WorkOrderItemService interface.
 */
@Service
@Validated
public class WorkOrderItemServiceImpl implements WorkOrderItemService {

    private static final Logger logger = LoggerFactory.getLogger(WorkOrderItemServiceImpl.class);

    @Autowired
    private WorkOrderItemRepository repository;

    @Override
    public WorkOrderItem createWorkOrderItem(@Valid WorkOrderItem workOrderItem) {
        logger.info("Creating new Work Order Item: {}", workOrderItem);
        return repository.save(workOrderItem);
    }

    @Override
    public WorkOrderItem getWorkOrderItemById(Long id) {
        logger.info("Fetching Work Order Item with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<WorkOrderItem> getAllWorkOrderItems() {
        logger.info("Fetching all Work Order Items");
        return repository.findAll();
    }

    @Override
    public WorkOrderItem updateWorkOrderItem(@Valid WorkOrderItem workOrderItem) {
        logger.info("Updating Work Order Item: {}", workOrderItem);
        return repository.save(workOrderItem);
    }

    @Override
    public void deleteWorkOrderItem(Long id) {
        logger.info("Deleting Work Order Item with ID: {}", id);
        repository.deleteById(id);
    }
}
