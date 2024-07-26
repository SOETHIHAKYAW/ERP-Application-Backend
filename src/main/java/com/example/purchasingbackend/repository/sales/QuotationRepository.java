package com.example.purchasingbackend.repository.sales;

import com.example.purchasingbackend.entity.sales.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotationRepository extends JpaRepository<Quotation, Long> {
}
