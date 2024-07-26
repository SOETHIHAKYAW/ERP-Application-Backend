package com.example.purchasingbackend.repository.sales;

import com.example.purchasingbackend.entity.sales.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long> {
}
