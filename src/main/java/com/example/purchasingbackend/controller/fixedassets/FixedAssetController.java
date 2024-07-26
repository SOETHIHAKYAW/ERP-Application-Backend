package com.example.purchasingbackend.controller.fixedassets;

import com.example.purchasingbackend.entity.fixedassets.FixedAsset;
import com.example.purchasingbackend.service.fixedassets.FixedAssetService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Fixed Assets.
 */
@RestController
@RequestMapping("/api/fixed-assets")
@Validated
public class FixedAssetController {

    private static final Logger logger = LoggerFactory.getLogger(FixedAssetController.class);

    @Autowired
    private FixedAssetService fixedAssetService;

    @PostMapping
    public ResponseEntity<FixedAsset> createFixedAsset(@Valid @RequestBody FixedAsset fixedAsset) {
        logger.info("Creating new Fixed Asset: {}", fixedAsset);
        FixedAsset createdFixedAsset = fixedAssetService.createFixedAsset(fixedAsset);
        return ResponseEntity.ok(createdFixedAsset);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FixedAsset> getFixedAssetById(@PathVariable Long id) {
        logger.info("Fetching Fixed Asset with ID: {}", id);
        FixedAsset fixedAsset = fixedAssetService.getFixedAssetById(id);
        if (fixedAsset != null) {
            return ResponseEntity.ok(fixedAsset);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<FixedAsset>> getAllFixedAssets() {
        logger.info("Fetching all Fixed Assets");
        List<FixedAsset> fixedAssets = fixedAssetService.getAllFixedAssets();
        return ResponseEntity.ok(fixedAssets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FixedAsset> updateFixedAsset(
            @PathVariable Long id,
            @Valid @RequestBody FixedAsset fixedAsset) {
        logger.info("Updating Fixed Asset with ID: {}", id);
        fixedAsset.setId(id);  // Ensure the ID is set for the update
        FixedAsset updatedFixedAsset = fixedAssetService.updateFixedAsset(fixedAsset);
        if (updatedFixedAsset != null) {
            return ResponseEntity.ok(updatedFixedAsset);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFixedAsset(@PathVariable Long id) {
        logger.info("Deleting Fixed Asset with ID: {}", id);
        fixedAssetService.deleteFixedAsset(id);
        return ResponseEntity.noContent().build();
    }
}
