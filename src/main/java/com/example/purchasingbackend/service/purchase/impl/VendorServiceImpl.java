package com.example.purchasingbackend.service.purchase.impl;

import com.example.purchasingbackend.entity.purchase.Vendor;
import com.example.purchasingbackend.repository.purchase.VendorRepository;
import com.example.purchasingbackend.service.purchase.VendorService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of the VendorService interface.
 */
@Service
@Validated
public class VendorServiceImpl implements VendorService {

    private static final Logger logger = LoggerFactory.getLogger(VendorServiceImpl.class);

    @Autowired
    private VendorRepository repository;

    @Override
    public Vendor createVendor(@Valid Vendor vendor) {
        logger.info("Creating new Vendor: {}", vendor);
        return repository.save(vendor);
    }

    @Override
    public Vendor getVendorById(Long id) {
        logger.info("Fetching Vendor with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Vendor> getAllVendors() {
        logger.info("Fetching all Vendors");
        return repository.findAll();
    }

    @Override
    public Vendor updateVendor(@Valid Vendor vendor) {
        logger.info("Updating Vendor: {}", vendor);
        return repository.save(vendor);
    }

    @Override
    public void deleteVendor(Long id) {
        logger.info("Deleting Vendor with ID: {}", id);
        repository.deleteById(id);
    }
}
