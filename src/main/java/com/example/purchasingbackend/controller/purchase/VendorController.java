package com.example.purchasingbackend.controller.purchase;

import com.example.purchasingbackend.entity.purchase.Vendor;
import com.example.purchasingbackend.service.purchase.VendorService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Vendors.
 */
@RestController
@RequestMapping("/api/vendors")
@Validated
public class VendorController {

    private static final Logger logger = LoggerFactory.getLogger(VendorController.class);

    @Autowired
    private VendorService vendorService;

    @PostMapping
    public ResponseEntity<Vendor> createVendor(@Valid @RequestBody Vendor vendor) {
        logger.info("Creating new Vendor: {}", vendor);
        Vendor createdVendor = vendorService.createVendor(vendor);
        return ResponseEntity.ok(createdVendor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable Long id) {
        logger.info("Fetching Vendor with ID: {}", id);
        Vendor vendor = vendorService.getVendorById(id);
        if (vendor != null) {
            return ResponseEntity.ok(vendor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Vendor>> getAllVendors() {
        logger.info("Fetching all Vendors");
        List<Vendor> vendors = vendorService.getAllVendors();
        return ResponseEntity.ok(vendors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(
            @PathVariable Long id,
            @Valid @RequestBody Vendor vendor) {
        logger.info("Updating Vendor with ID: {}", id);
        vendor.setId(id);  // Ensure the ID is set for the update
        Vendor updatedVendor = vendorService.updateVendor(vendor);
        return ResponseEntity.ok(updatedVendor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendor(@PathVariable Long id) {
        logger.info("Deleting Vendor with ID: {}", id);
        vendorService.deleteVendor(id);
        return ResponseEntity.noContent().build();
    }
}
