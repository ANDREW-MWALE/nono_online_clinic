package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.PayrollEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends JpaRepository<PayrollEntry, Long> {
}
