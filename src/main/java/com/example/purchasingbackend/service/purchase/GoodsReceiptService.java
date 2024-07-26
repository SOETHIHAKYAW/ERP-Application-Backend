package com.example.purchasingbackend.service.purchase;

import com.example.purchasingbackend.entity.purchase.GoodsReceipt;
import jakarta.validation.Valid;

import java.util.List;

/**
 * Service interface for managing Goods Receipts.
 */
public interface GoodsReceiptService {
    GoodsReceipt createGoodsReceipt(@Valid GoodsReceipt goodsReceipt);

    GoodsReceipt getGoodsReceiptById(Long id);

    List<GoodsReceipt> getAllGoodsReceipts();

    GoodsReceipt updateGoodsReceipt(@Valid GoodsReceipt goodsReceipt);

    void deleteGoodsReceipt(Long id);
}
