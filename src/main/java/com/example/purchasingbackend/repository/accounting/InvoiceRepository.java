package com.example.purchasingbackend.repository.accounting;

import com.example.purchasingbackend.entity.accounting.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
