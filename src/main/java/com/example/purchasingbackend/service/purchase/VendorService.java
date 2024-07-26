package com.example.purchasingbackend.service.purchase;

import com.example.purchasingbackend.entity.purchase.Vendor;
import jakarta.validation.Valid;

import java.util.List;

public interface VendorService {
    Vendor createVendor(@Valid Vendor vendor);

    Vendor getVendorById(Long id);

    List<Vendor> getAllVendors();

    Vendor updateVendor(@Valid Vendor vendor);

    void deleteVendor(Long id);
}
