package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.ConsultationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<ConsultationModel, Long> {
}
