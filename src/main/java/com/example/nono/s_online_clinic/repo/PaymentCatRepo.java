package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.PaymentCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentCatRepo extends JpaRepository<PaymentCategoryModel, Long> {

}
