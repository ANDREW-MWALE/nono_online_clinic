    package com.example.nono.s_online_clinic.service.pharmacy_services;

    import com.example.nono.s_online_clinic.model.pharmacy.Stock_Items;
    import com.example.nono.s_online_clinic.repo.pharmacy_repository.StockRepository;
    import org.springframework.stereotype.Service;

    import java.time.LocalDateTime;
    import java.util.List;

    @Service
    public class StockService {
        public StockRepository stockRepository;

        // Constructor Injection
        public StockService(StockRepository stockRepository) {
            this.stockRepository = stockRepository;
        }

        public Stock_Items add(Stock_Items stockItems) {
            return stockRepository.save(stockItems);
        }

        public List<Stock_Items> getItems() {
          return  stockRepository.findAll();
        }

        public Stock_Items updateItems(Long id, Stock_Items stockItems) {

            Stock_Items existingItem = stockRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            existingItem.setName(stockItems.getName());
            existingItem.setCategory(stockItems.getCategory());
            existingItem.setQuantity(stockItems.getQuantity());
            existingItem.setExpiryDate(stockItems.getExpiryDate());
            existingItem.setModifiedBy(stockItems.getModifiedBy());
            existingItem.setModifiedDate(LocalDateTime.now());

            return stockRepository.save(existingItem);
        }

        public Stock_Items deleteItems(Long id) {

            Stock_Items item = stockRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            stockRepository.delete(item);
            return item;
        }
    }
