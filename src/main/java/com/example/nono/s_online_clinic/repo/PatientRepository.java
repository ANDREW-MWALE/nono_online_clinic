package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> {
    List<PatientModel> findByRegistrationDate(LocalDate date);
}
