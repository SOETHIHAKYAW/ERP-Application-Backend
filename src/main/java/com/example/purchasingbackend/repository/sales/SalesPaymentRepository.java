package com.example.purchasingbackend.repository.sales;

import com.example.purchasingbackend.entity.sales.SalesPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesPaymentRepository extends JpaRepository<SalesPayment, Long> {
}
