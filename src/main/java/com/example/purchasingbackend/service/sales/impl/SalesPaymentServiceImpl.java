package com.example.purchasingbackend.service.sales;

import com.example.purchasingbackend.entity.sales.SalesPayment;
import com.example.purchasingbackend.repository.sales.SalesPaymentRepository;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of SalesPaymentService interface.
 */
@Service
public class SalesPaymentServiceImpl implements SalesPaymentService {

    private static final Logger logger = LoggerFactory.getLogger(SalesPaymentServiceImpl.class);

    @Autowired
    private SalesPaymentRepository salesPaymentRepository;

    @Override
    public SalesPayment createSalesPayment(SalesPayment payment) {
        logger.info("Creating Sales Payment: {}", payment);
        // Validate the Sales Payment before saving
        validatePayment(payment);
        SalesPayment createdPayment = salesPaymentRepository.save(payment);
        logger.info("Created Sales Payment: {}", createdPayment);
        return createdPayment;
    }

    @Override
    public SalesPayment getSalesPaymentById(Long id) {
        logger.info("Fetching Sales Payment with ID: {}", id);
        Optional<SalesPayment> payment = salesPaymentRepository.findById(id);
        if (payment.isPresent()) {
            logger.info("Found Sales Payment: {}", payment.get());
            return payment.get();
        } else {
            logger.warn("Sales Payment with ID {} not found", id);
            return null;
        }
    }

    @Override
    public List<SalesPayment> getAllSalesPayments() {
        logger.info("Fetching all Sales Payments");
        List<SalesPayment> payments = salesPaymentRepository.findAll();
        logger.info("Found {} Sales Payments", payments.size());
        return payments;
    }

    @Override
    public SalesPayment updateSalesPayment(SalesPayment payment) {
        logger.info("Updating Sales Payment: {}", payment);
        if (payment.getId() == null || !salesPaymentRepository.existsById(payment.getId())) {
            logger.warn("Sales Payment with ID {} does not exist for update", payment.getId());
            throw new ValidationException("Payment not found for update");
        }
        // Validate the Sales Payment before updating
        validatePayment(payment);
        SalesPayment updatedPayment = salesPaymentRepository.save(payment);
        logger.info("Updated Sales Payment: {}", updatedPayment);
        return updatedPayment;
    }

    @Override
    public void deleteSalesPayment(Long id) {
        logger.info("Deleting Sales Payment with ID: {}", id);
        if (!salesPaymentRepository.existsById(id)) {
            logger.warn("Sales Payment with ID {} does not exist for deletion", id);
            throw new ValidationException("Payment not found for deletion");
        }
        salesPaymentRepository.deleteById(id);
        logger.info("Deleted Sales Payment with ID: {}", id);
    }

    /**
     * Validate the Sales Payment entity.
     *
     * @param payment SalesPayment entity to validate
     */
    private void validatePayment(SalesPayment payment) {
        // Ensure the payment is not null
        if (payment == null) {
            throw new ValidationException("Payment cannot be null");
        }
        // Example: Validate required fields
        if (payment.getAmount() == null || payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Payment amount must be greater than zero");
        }
        if (payment.getPaymentDate() == null) {
            throw new ValidationException("Payment date must be provided");
        }
        if (payment.getInvoice() == null) {
            throw new ValidationException("Associated invoice must be specified");
        }
    }
}
