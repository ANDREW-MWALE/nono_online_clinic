package com.example.nono.s_online_clinic.service.pharmacy_services;

import com.example.nono.s_online_clinic.model.pharmacy.Sales;
import com.example.nono.s_online_clinic.repo.pharmacy_repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public Sales add(Sales sales) {
        return saleRepository.save(sales);
    }

    public List<Sales> getItems() {
        return saleRepository.findAll();
    }

    public Sales updateItems(Long id, Sales sales) {
        Sales existingSales = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        existingSales.setMedicineName(sales.getMedicineName());
        existingSales.setAvailableQty(sales.getAvailableQty());
        existingSales.setSaleQty(sales.getSaleQty());
        existingSales.setUnitPrice(sales.getUnitPrice());
        existingSales.setModifiedBy(sales.getModifiedBy());
        existingSales.setModifiedDate(LocalDateTime.now());

        return saleRepository.save(existingSales);
    }

    public Sales deleteSales(Long id) {
        Sales sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));

        saleRepository.delete(sale);
        return sale;
    }
}