package com.example.purchasingbackend.service.accounting;

import com.example.purchasingbackend.entity.accounting.Payment;
import jakarta.validation.Valid;

import java.util.List;

/**
 * Service interface for managing Payments.
 */
public interface PaymentService {
    Payment createPayment(@Valid Payment payment);

    Payment getPaymentById(Long id);

    List<Payment> getAllPayments();

    Payment updatePayment(@Valid Payment payment);

    void deletePayment(Long id);
}
