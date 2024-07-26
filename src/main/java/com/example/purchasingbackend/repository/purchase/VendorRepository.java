package com.example.purchasingbackend.repository.purchase;

import com.example.purchasingbackend.entity.purchase.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
