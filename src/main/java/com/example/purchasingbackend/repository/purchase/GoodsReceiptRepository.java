package com.example.purchasingbackend.repository.purchase;

import com.example.purchasingbackend.entity.purchase.GoodsReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsReceiptRepository extends JpaRepository<GoodsReceipt, Long> {
}
