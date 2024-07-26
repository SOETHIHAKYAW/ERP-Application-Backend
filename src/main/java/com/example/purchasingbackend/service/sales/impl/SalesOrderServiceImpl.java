package com.example.purchasingbackend.service.sales.impl;

import com.example.purchasingbackend.entity.sales.SalesOrder;
import com.example.purchasingbackend.repository.sales.SalesOrderRepository;
import com.example.purchasingbackend.service.sales.SalesOrderService;
import jakarta.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of SalesOrderService interface.
 */
@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    private static final Logger logger = LoggerFactory.getLogger(SalesOrderServiceImpl.class);

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Override
    public SalesOrder createSalesOrder(SalesOrder order) {
        logger.info("Creating Sales Order: {}", order);
        // Validate the Sales Order before saving
        validateOrder(order);
        SalesOrder createdOrder = salesOrderRepository.save(order);
        logger.info("Created Sales Order: {}", createdOrder);
        return createdOrder;
    }

    @Override
    public SalesOrder getSalesOrderById(Long id) {
        logger.info("Fetching Sales Order with ID: {}", id);
        Optional<SalesOrder> order = salesOrderRepository.findById(id);
        if (order.isPresent()) {
            logger.info("Found Sales Order: {}", order.get());
            return order.get();
        } else {
            logger.warn("Sales Order with ID {} not found", id);
            return null;
        }
    }

    @Override
    public List<SalesOrder> getAllSalesOrders() {
        logger.info("Fetching all Sales Orders");
        List<SalesOrder> orders = salesOrderRepository.findAll();
        logger.info("Found {} Sales Orders", orders.size());
        return orders;
    }

    @Override
    public SalesOrder updateSalesOrder(SalesOrder order) {
        logger.info("Updating Sales Order: {}", order);
        if (order.getId() == null || !salesOrderRepository.existsById(order.getId())) {
            logger.warn("Sales Order with ID {} does not exist for update", order.getId());
            throw new ValidationException("Order not found for update");
        }
        // Validate the Sales Order before updating
        validateOrder(order);
        SalesOrder updatedOrder = salesOrderRepository.save(order);
        logger.info("Updated Sales Order: {}", updatedOrder);
        return updatedOrder;
    }

    @Override
    public void deleteSalesOrder(Long id) {
        logger.info("Deleting Sales Order with ID: {}", id);
        if (!salesOrderRepository.existsById(id)) {
            logger.warn("Sales Order with ID {} does not exist for deletion", id);
            throw new ValidationException("Order not found for deletion");
        }
        salesOrderRepository.deleteById(id);
        logger.info("Deleted Sales Order with ID: {}", id);
    }

    /**
     * Validate the Sales Order entity.
     *
     * @param order SalesOrder entity to validate
     */
    private void validateOrder(SalesOrder order) {
        // Ensure the order is not null
        if (order == null) {
            throw new ValidationException("Order cannot be null");
        }
        // Example: Validate required fields
        if (order.getOrderDate() == null) {
            throw new ValidationException("Order date must be provided");
        }
    }
}
