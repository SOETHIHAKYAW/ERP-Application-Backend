package com.example.purchasingbackend.service.sales;

import com.example.purchasingbackend.entity.sales.SalesPayment;
import jakarta.validation.Valid;

import java.util.List;

public interface SalesPaymentService {
    SalesPayment createSalesPayment(@Valid SalesPayment payment);

    SalesPayment getSalesPaymentById(Long id);

    List<SalesPayment> getAllSalesPayments();

    SalesPayment updateSalesPayment(@Valid SalesPayment payment);

    void deleteSalesPayment(Long id);
}
