package com.example.purchasingbackend.service.accounting;

import com.example.purchasingbackend.entity.accounting.Invoice;
import jakarta.validation.Valid;

import java.util.List;

/**
 * Service interface for managing Invoices.
 */
public interface InvoiceService {
    Invoice createInvoice(@Valid Invoice invoice);

    Invoice getInvoiceById(Long id);

    List<Invoice> getAllInvoices();

    Invoice updateInvoice(@Valid Invoice invoice);

    void deleteInvoice(Long id);
}
