package com.example.nono.s_online_clinic.service.pharmacy_services;

import com.example.nono.s_online_clinic.model.pharmacy.Suppliers;
import com.example.nono.s_online_clinic.repo.pharmacy_repository.SupplierRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRespository supplierRespository;

    public Suppliers add(Suppliers supplier) {
        return supplierRespository.save(supplier);
    }

    public List<Suppliers> getItems() {
        return supplierRespository.findAll();
    }

    public Suppliers updateItems(Long id, Suppliers supplier) {
        Suppliers existingSupplier = supplierRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        // Set the ID so save() updates the existing row instead of inserting a new one
        supplier.setSupplierId(id); // adjust to your actual PK field/setter name
        return supplierRespository.save(supplier);
    }

    public Suppliers deleteSupplier(Long id) {
        Suppliers supplier = supplierRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        supplierRespository.delete(supplier);
        return supplier;
    }
}