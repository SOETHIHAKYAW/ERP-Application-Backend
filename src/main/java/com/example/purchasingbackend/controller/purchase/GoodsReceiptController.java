package com.example.purchasingbackend.controller.purchase;

import com.example.purchasingbackend.entity.purchase.GoodsReceipt;
import com.example.purchasingbackend.service.purchase.GoodsReceiptService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Goods Receipts.
 */
@RestController
@RequestMapping("/api/goods-receipts")
@Validated
public class GoodsReceiptController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsReceiptController.class);

    @Autowired
    private GoodsReceiptService goodsReceiptService;

    @PostMapping
    public ResponseEntity<GoodsReceipt> createGoodsReceipt(@Valid @RequestBody GoodsReceipt goodsReceipt) {
        logger.info("Creating new Goods Receipt: {}", goodsReceipt);
        GoodsReceipt createdReceipt = goodsReceiptService.createGoodsReceipt(goodsReceipt);
        return ResponseEntity.ok(createdReceipt);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GoodsReceipt> getGoodsReceiptById(@PathVariable Long id) {
        logger.info("Fetching Goods Receipt with ID: {}", id);
        GoodsReceipt receipt = goodsReceiptService.getGoodsReceiptById(id);
        if (receipt != null) {
            return ResponseEntity.ok(receipt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<GoodsReceipt>> getAllGoodsReceipts() {
        logger.info("Fetching all Goods Receipts");
        List<GoodsReceipt> receipts = goodsReceiptService.getAllGoodsReceipts();
        return ResponseEntity.ok(receipts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GoodsReceipt> updateGoodsReceipt(
            @PathVariable Long id,
            @Valid @RequestBody GoodsReceipt goodsReceipt) {
        logger.info("Updating Goods Receipt with ID: {}", id);
        goodsReceipt.setId(id);  // Ensure the ID is set for the update
        GoodsReceipt updatedReceipt = goodsReceiptService.updateGoodsReceipt(goodsReceipt);
        return ResponseEntity.ok(updatedReceipt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoodsReceipt(@PathVariable Long id) {
        logger.info("Deleting Goods Receipt with ID: {}", id);
        goodsReceiptService.deleteGoodsReceipt(id);
        return ResponseEntity.noContent().build();
    }
}
