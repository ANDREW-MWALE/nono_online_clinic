package com.example.nono.s_online_clinic.controller.pharmacy_controllers;

import com.example.nono.s_online_clinic.model.pharmacy.Suppliers;
import com.example.nono.s_online_clinic.service.pharmacy_services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    public SupplierService supplierService;

    @PostMapping("/add")
    public Suppliers addSupplier(@RequestBody Suppliers supplier) {
        return supplierService.add(supplier);
    }

    @GetMapping
    public ResponseEntity<List<Suppliers>> getSuppliers() {
        List<Suppliers> items = supplierService.getItems();

        if (items.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Suppliers> editSupplier(@PathVariable Long id, @RequestBody Suppliers supplier) {
        Suppliers updatedSupplier = supplierService.updateItems(id, supplier);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Suppliers> deleteSupplier(@PathVariable Long id) {
        Suppliers supplier = supplierService.deleteSupplier(id);
        return ResponseEntity.ok(supplier);
    }
}