package com.example.purchasingbackend.service.purchase;

import com.example.purchasingbackend.entity.purchase.PurchaseRequisition;
import jakarta.validation.Valid;

import java.util.List;

public interface PurchaseRequisitionService {
    PurchaseRequisition createPurchaseRequisition(@Valid PurchaseRequisition requisition);

    PurchaseRequisition getPurchaseRequisitionById(Long id);

    List<PurchaseRequisition> getAllPurchaseRequisitions();

    PurchaseRequisition updatePurchaseRequisition(@Valid PurchaseRequisition requisition);

    void deletePurchaseRequisition(Long id);
}
