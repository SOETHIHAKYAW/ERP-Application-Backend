package com.example.purchasingbackend.service.sales;

import com.example.purchasingbackend.entity.sales.Lead;
import jakarta.validation.Valid;

import java.util.List;

public interface LeadService {
    Lead createLead(@Valid Lead lead);

    Lead getLeadById(Long id);

    List<Lead> getAllLeads();

    Lead updateLead(@Valid Lead lead);

    void deleteLead(Long id);
}
