package com.example.purchasingbackend.service.sales;

import com.example.purchasingbackend.entity.sales.SalesOrder;
import jakarta.validation.Valid;

import java.util.List;

public interface SalesOrderService {
    SalesOrder createSalesOrder(@Valid SalesOrder order);

    SalesOrder getSalesOrderById(Long id);

    List<SalesOrder> getAllSalesOrders();

    SalesOrder updateSalesOrder(@Valid SalesOrder order);

    void deleteSalesOrder(Long id);
}
