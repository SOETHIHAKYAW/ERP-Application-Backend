package com.example.purchasingbackend.service.manufacturing;

import com.example.purchasingbackend.entity.manufacturing.WorkOrderItem;
import jakarta.validation.Valid;

import java.util.List;

public interface WorkOrderItemService {
    WorkOrderItem createWorkOrderItem(@Valid WorkOrderItem item);

    WorkOrderItem getWorkOrderItemById(Long id);

    List<WorkOrderItem> getAllWorkOrderItems();

    WorkOrderItem updateWorkOrderItem(@Valid WorkOrderItem item);

    void deleteWorkOrderItem(Long id);
}
