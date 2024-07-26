package com.example.purchasingbackend.service.sales;

import com.example.purchasingbackend.entity.sales.Opportunity;
import jakarta.validation.Valid;

import java.util.List;

public interface OpportunityService {
    Opportunity createOpportunity(@Valid Opportunity opportunity);

    Opportunity getOpportunityById(Long id);

    List<Opportunity> getAllOpportunities();

    Opportunity updateOpportunity(@Valid Opportunity opportunity);

    void deleteOpportunity(Long id);
}
