package com.example.purchasingbackend.service.manufacturing.impl;

import com.example.purchasingbackend.entity.manufacturing.WorkOrder;
import com.example.purchasingbackend.repository.manufacturing.WorkOrderRepository;
import com.example.purchasingbackend.service.manufacturing.WorkOrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of the WorkOrderService interface.
 */
@Service
@Validated
public class WorkOrderServiceImpl implements WorkOrderService {

    private static final Logger logger = LoggerFactory.getLogger(WorkOrderServiceImpl.class);

    @Autowired
    private WorkOrderRepository repository;

    @Override
    public WorkOrder createWorkOrder(@Valid WorkOrder workOrder) {
        logger.info("Creating new Work Order: {}", workOrder);
        return repository.save(workOrder);
    }

    @Override
    public WorkOrder getWorkOrderById(Long id) {
        logger.info("Fetching Work Order with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<WorkOrder> getAllWorkOrders() {
        logger.info("Fetching all Work Orders");
        return repository.findAll();
    }

    @Override
    public WorkOrder updateWorkOrder(@Valid WorkOrder workOrder) {
        logger.info("Updating Work Order: {}", workOrder);
        return repository.save(workOrder);
    }

    @Override
    public void deleteWorkOrder(Long id) {
        logger.info("Deleting Work Order with ID: {}", id);
        repository.deleteById(id);
    }
}
