package com.example.purchasingbackend.service.fixedassets.impl;

import com.example.purchasingbackend.entity.fixedassets.FixedAsset;
import com.example.purchasingbackend.repository.fixedassets.FixedAssetRepository;
import com.example.purchasingbackend.service.fixedassets.FixedAssetService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * Implementation of FixedAssetService interface.
 */
@Service
@Validated
public class FixedAssetServiceImpl implements FixedAssetService {

    private static final Logger logger = LoggerFactory.getLogger(FixedAssetServiceImpl.class);

    @Autowired
    private FixedAssetRepository repository;

    @Override
    public FixedAsset createFixedAsset(@Valid FixedAsset fixedAsset) {
        logger.info("Creating new Fixed Asset: {}", fixedAsset);
        return repository.save(fixedAsset);
    }

    @Override
    public FixedAsset getFixedAssetById(Long id) {
        logger.info("Fetching Fixed Asset with ID: {}", id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<FixedAsset> getAllFixedAssets() {
        logger.info("Fetching all Fixed Assets");
        return repository.findAll();
    }

    @Override
    public FixedAsset updateFixedAsset(@Valid FixedAsset fixedAsset) {
        logger.info("Updating Fixed Asset: {}", fixedAsset);
        return repository.save(fixedAsset);
    }

    @Override
    public void deleteFixedAsset(Long id) {
        logger.info("Deleting Fixed Asset with ID: {}", id);
        repository.deleteById(id);
    }
}
