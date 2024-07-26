package com.example.purchasingbackend.service.fixedassets;

import com.example.purchasingbackend.entity.fixedassets.FixedAsset;
import jakarta.validation.Valid;

import java.util.List;

/**
 * Service interface for managing FixedAssets.
 */
public interface FixedAssetService {

    FixedAsset createFixedAsset(@Valid FixedAsset fixedAsset);

    FixedAsset getFixedAssetById(Long id);

    List<FixedAsset> getAllFixedAssets();

    FixedAsset updateFixedAsset(@Valid FixedAsset fixedAsset);

    void deleteFixedAsset(Long id);
}
