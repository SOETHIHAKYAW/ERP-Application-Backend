package com.example.purchasingbackend.service.sales;

import com.example.purchasingbackend.entity.sales.Quotation;
import jakarta.validation.Valid;

import java.util.List;

public interface QuotationService {
    Quotation createQuotation(@Valid Quotation quotation);

    Quotation getQuotationById(Long id);

    List<Quotation> getAllQuotations();

    Quotation updateQuotation(@Valid Quotation quotation);

    void deleteQuotation(Long id);
}
