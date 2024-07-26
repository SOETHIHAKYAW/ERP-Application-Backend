package com.example.purchasingbackend.service.manufacturing.impl;

import com.example.purchasingbackend.entity.manufacturing.WorkOrderOperation;
import com.example.purchasingbackend.repository.manufacturing.WorkOrderOperationRepository;
import com.example.purchasingbackend.service.manufacturing.WorkOrderOperationService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of the WorkOrderOperationService interface.
 */
@Service
@Validated
public class WorkOrderOperationServiceImpl implements WorkOrderOperationService {

    private static final Logger logger = LoggerFactory.getLogger(WorkOrderOperationServiceImpl.class);

    @Autowired
    private WorkOrderOperationRepository repository;

    @Override
    public WorkOrderOperation createWorkOrderOperation(@Valid WorkOrderOperation workOrderOperation) {
        logger.info("Creating new Work Order Operation: {}", workOrderOperation);
        return repository.save(workOrderOperation);
    }

    @Override
    public WorkOrderOperation getWorkOrderOperationById(Long id) {
        logger.info("Fetching Work Order Operation with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<WorkOrderOperation> getAllWorkOrderOperations() {
        logger.info("Fetching all Work Order Operations");
        return repository.findAll();
    }

    @Override
    public WorkOrderOperation updateWorkOrderOperation(@Valid WorkOrderOperation workOrderOperation) {
        logger.info("Updating Work Order Operation: {}", workOrderOperation);
        return repository.save(workOrderOperation);
    }

    @Override
    public void deleteWorkOrderOperation(Long id) {
        logger.info("Deleting Work Order Operation with ID: {}", id);
        repository.deleteById(id);
    }
}
