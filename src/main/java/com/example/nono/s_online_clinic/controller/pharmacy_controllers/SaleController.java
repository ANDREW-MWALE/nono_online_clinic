package com.example.nono.s_online_clinic.controller.pharmacy_controllers;

import com.example.nono.s_online_clinic.model.pharmacy.Sales;
import com.example.nono.s_online_clinic.model.pharmacy.Stock_Items;
import com.example.nono.s_online_clinic.service.pharmacy_services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping("/add")
    public Sales addSales(@RequestBody Sales sales) {
        System.out.println("We are reaching here ");
        return saleService.add(sales);
    }

    @GetMapping
    public ResponseEntity<List<Sales>> getSales() {
        List<Sales> SaleItems= saleService.getItems();

        if (SaleItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(SaleItems);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sales> editSales(@PathVariable Long id, @RequestBody Sales sales) {
        Sales sale  = saleService.updateItems(id, sales);
        return ResponseEntity.ok(sale);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Sales> deleteSaleItems(@PathVariable Long id) {
        Sales deleteSales = saleService.deleteSales(id);
        return ResponseEntity.ok(deleteSales);
    }
}