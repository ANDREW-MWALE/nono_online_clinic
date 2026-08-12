package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.LaboratoryModel.LaboratoryTestModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaboratoryTestRepo extends JpaRepository<LaboratoryTestModel, Long> {
}
