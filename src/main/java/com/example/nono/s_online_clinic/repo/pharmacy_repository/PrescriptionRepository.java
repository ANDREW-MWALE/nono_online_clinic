package com.example.nono.s_online_clinic.repo.pharmacy_repository;

import com.example.nono.s_online_clinic.model.pharmacy.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
}