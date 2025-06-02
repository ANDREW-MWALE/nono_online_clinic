package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.VitalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitalRepository extends JpaRepository<VitalModel, Long> {
    List<VitalModel> findByPatientModel_PatientId(Long patientId);
}
