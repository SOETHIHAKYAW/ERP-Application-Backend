package com.example.purchasingbackend.service.manufacturing;

import com.example.purchasingbackend.entity.manufacturing.WorkOrder;
import jakarta.validation.Valid;

import java.util.List;

public interface WorkOrderService {
    WorkOrder createWorkOrder(@Valid WorkOrder workOrder);

    WorkOrder getWorkOrderById(Long id);

    List<WorkOrder> getAllWorkOrders();

    WorkOrder updateWorkOrder(@Valid WorkOrder workOrder);

    void deleteWorkOrder(Long id);
}
