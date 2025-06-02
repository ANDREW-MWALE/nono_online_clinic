package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.PrescriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepo extends JpaRepository<PrescriptionModel, Long> {
}
