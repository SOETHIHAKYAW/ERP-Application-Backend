package com.example.purchasingbackend.repository.accounting;

import com.example.purchasingbackend.entity.accounting.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
