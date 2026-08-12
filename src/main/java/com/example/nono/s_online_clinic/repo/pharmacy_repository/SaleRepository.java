package com.example.nono.s_online_clinic.repo.pharmacy_repository;

import com.example.nono.s_online_clinic.model.pharmacy.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sales, Long> {
}
