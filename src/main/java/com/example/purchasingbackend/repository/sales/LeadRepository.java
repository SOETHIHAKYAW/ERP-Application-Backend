package com.example.purchasingbackend.repository.sales;

import com.example.purchasingbackend.entity.sales.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {
}
