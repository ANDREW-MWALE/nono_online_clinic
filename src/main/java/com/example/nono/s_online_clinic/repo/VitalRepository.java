package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.VitalModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VitalRepository extends JpaRepository<VitalModel, Long> {

    // Assumes PatientModel has a field/getter "patientId" -> patient_id column
    List<VitalModel> findByPatientModel_PatientId(Long patientId);
}