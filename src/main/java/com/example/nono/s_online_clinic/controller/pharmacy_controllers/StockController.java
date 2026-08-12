package com.example.nono.s_online_clinic.controller.pharmacy_controllers;

import com.example.nono.s_online_clinic.model.pharmacy.Stock_Items;
import com.example.nono.s_online_clinic.service.pharmacy_services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

 @Autowired
 public StockService stockService;

 @PostMapping("/add")
 public Stock_Items addPharmacyStock(@RequestBody Stock_Items stockItems) {
  return stockService.add(stockItems);
 }

 @GetMapping
 public ResponseEntity<List<Stock_Items>> getStockedItems() {
  List<Stock_Items> items = stockService.getItems();

  if (items.isEmpty()) {
   return ResponseEntity.noContent().build();
  }
  return ResponseEntity.ok(items);
 }

 @PutMapping("/{id}")
 public ResponseEntity<Stock_Items> editStock(@PathVariable Long id, @RequestBody Stock_Items stockItems) {
  Stock_Items updatedItems = stockService.updateItems(id, stockItems);
  return ResponseEntity.ok(updatedItems);
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Stock_Items> deleteStockItems(@PathVariable Long id) {
  Stock_Items item = stockService.deleteItems(id);
  return ResponseEntity.ok(item);
 }
}