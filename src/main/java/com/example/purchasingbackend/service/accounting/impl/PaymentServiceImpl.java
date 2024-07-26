package com.example.purchasingbackend.service.accounting.impl;

import com.example.purchasingbackend.entity.accounting.Payment;
import com.example.purchasingbackend.repository.accounting.PaymentRepository;
import com.example.purchasingbackend.service.accounting.PaymentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of PaymentService interface.
 */
@Service
@Validated
public class PaymentServiceImpl implements PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentRepository repository;

    @Override
    public Payment createPayment(@Valid Payment payment) {
        logger.info("Creating new Payment: {}", payment);
        return repository.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        logger.info("Fetching Payment with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        logger.info("Fetching all Payments");
        return repository.findAll();
    }

    @Override
    public Payment updatePayment(@Valid Payment payment) {
        logger.info("Updating Payment: {}", payment);
        return repository.save(payment);
    }

    @Override
    public void deletePayment(Long id) {
        logger.info("Deleting Payment with ID: {}", id);
        repository.deleteById(id);
    }
}
