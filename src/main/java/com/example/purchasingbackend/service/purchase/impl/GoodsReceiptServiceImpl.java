package com.example.purchasingbackend.service.purchase.impl;

import com.example.purchasingbackend.entity.purchase.GoodsReceipt;
import com.example.purchasingbackend.repository.purchase.GoodsReceiptRepository;
import com.example.purchasingbackend.service.purchase.GoodsReceiptService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing Goods Receipts.
 */
@Service
public class GoodsReceiptServiceImpl implements GoodsReceiptService {

    private static final Logger logger = LoggerFactory.getLogger(GoodsReceiptServiceImpl.class);

    @Autowired
    private GoodsReceiptRepository goodsReceiptRepository;

    @Override
    public GoodsReceipt createGoodsReceipt(@Valid GoodsReceipt goodsReceipt) {
        logger.info("Creating Goods Receipt: {}", goodsReceipt);
        return goodsReceiptRepository.save(goodsReceipt);
    }

    @Override
    public GoodsReceipt getGoodsReceiptById(Long id) {
        logger.info("Fetching Goods Receipt with ID: {}", id);
        Optional<GoodsReceipt> receipt = goodsReceiptRepository.findById(id);
        return receipt.orElse(null);
    }

    @Override
    public List<GoodsReceipt> getAllGoodsReceipts() {
        logger.info("Fetching all Goods Receipts");
        return goodsReceiptRepository.findAll();
    }

    @Override
    public GoodsReceipt updateGoodsReceipt(@Valid GoodsReceipt goodsReceipt) {
        logger.info("Updating Goods Receipt: {}", goodsReceipt);
        if (goodsReceiptRepository.existsById(goodsReceipt.getId())) {
            return goodsReceiptRepository.save(goodsReceipt);
        } else {
            return null;
        }
    }

    @Override
    public void deleteGoodsReceipt(Long id) {
        logger.info("Deleting Goods Receipt with ID: {}", id);
        goodsReceiptRepository.deleteById(id);
    }
}
