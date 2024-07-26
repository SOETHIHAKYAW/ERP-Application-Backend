package com.example.purchasingbackend.repository.fixedassets;

import com.example.purchasingbackend.entity.fixedassets.FixedAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedAssetRepository extends JpaRepository<FixedAsset, Long> {
}
