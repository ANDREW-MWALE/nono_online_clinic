package com.example.nono.s_online_clinic.repo.pharmacy_repository;

import com.example.nono.s_online_clinic.model.pharmacy.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.function.Supplier;

public interface SupplierRespository extends JpaRepository<Suppliers, Long> {
}
