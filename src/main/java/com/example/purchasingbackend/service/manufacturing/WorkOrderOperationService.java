package com.example.purchasingbackend.service.manufacturing;

import com.example.purchasingbackend.entity.manufacturing.WorkOrderOperation;
import jakarta.validation.Valid;

import java.util.List;

/**
 * Service interface for managing WorkOrderOperations.
 */
public interface WorkOrderOperationService {

    /**
     * Creates a new WorkOrderOperation.
     *
     * @param workOrderOperation The WorkOrderOperation to create.
     * @return The created WorkOrderOperation.
     */
    WorkOrderOperation createWorkOrderOperation(@Valid WorkOrderOperation workOrderOperation);

    /**
     * Retrieves a WorkOrderOperation by its ID.
     *
     * @param id The ID of the WorkOrderOperation.
     * @return The WorkOrderOperation with the given ID, or null if not found.
     */
    WorkOrderOperation getWorkOrderOperationById(Long id);

    /**
     * Retrieves all WorkOrderOperations.
     *
     * @return A list of all WorkOrderOperations.
     */
    List<WorkOrderOperation> getAllWorkOrderOperations();

    /**
     * Updates an existing WorkOrderOperation.
     *
     * @param workOrderOperation The WorkOrderOperation to update.
     * @return The updated WorkOrderOperation.
     */
    WorkOrderOperation updateWorkOrderOperation(@Valid WorkOrderOperation workOrderOperation);

    /**
     * Deletes a WorkOrderOperation by its ID.
     *
     * @param id The ID of the WorkOrderOperation to delete.
     */
    void deleteWorkOrderOperation(Long id);
}
