package com.example.purchasingbackend.service.sales;

import com.example.purchasingbackend.entity.sales.SalesInvoice;
import jakarta.validation.Valid;

import java.util.List;

public interface SalesInvoiceService {
    SalesInvoice createSalesInvoice(@Valid SalesInvoice invoice);

    SalesInvoice getSalesInvoiceById(Long id);

    List<SalesInvoice> getAllSalesInvoices();

    SalesInvoice updateSalesInvoice(@Valid SalesInvoice invoice);

    void deleteSalesInvoice(Long id);
}
