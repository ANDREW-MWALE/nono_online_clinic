package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabOrderRepo extends JpaRepository<OrderModel, Long> {
}
