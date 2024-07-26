package com.example.purchasingbackend.service.purchase;

import com.example.purchasingbackend.entity.purchase.PurchaseOrder;
import jakarta.validation.Valid;

import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrder createPurchaseOrder(@Valid PurchaseOrder purchaseOrder);

    PurchaseOrder getPurchaseOrderById(Long id);

    List<PurchaseOrder> getAllPurchaseOrders();

    PurchaseOrder updatePurchaseOrder(@Valid PurchaseOrder purchaseOrder);

    void deletePurchaseOrder(Long id);
}
