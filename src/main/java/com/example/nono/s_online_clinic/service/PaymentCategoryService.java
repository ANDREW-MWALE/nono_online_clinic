package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.PaymentCategoryModel;
import com.example.nono.s_online_clinic.model.StaffModel;
import com.example.nono.s_online_clinic.repo.PaymentCatRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentCategoryService {

    @Autowired
    private PaymentCatRepo paymentCatRepo;

    public PaymentCategoryService(PaymentCatRepo paymentCatRepo) {
        this.paymentCatRepo = paymentCatRepo;
    }

    public PaymentCategoryModel addPaymentCategory(PaymentCategoryModel paymentCategoryModel) {
        return paymentCatRepo.save(paymentCategoryModel);
    }

    public List<PaymentCategoryModel> getAllPayList() {
        return paymentCatRepo.findAll();
    }

//    public PaymentCategoryModel updateCategory(Long pid, PaymentCategoryModel paymentCategoryModel) {
//        PaymentCategoryModel category = paymentCatRepo.findById(pid)
//                .orElseThrow(() -> new RuntimeException(" This category is not present"));
//        category.setCategoryName(paymentCategoryModel.getCategoryName());
//        return paymentCatRepo.save(category);
//    }
public PaymentCategoryModel updateCategory(Long PID, PaymentCategoryModel paymentCategoryModel) {
    try {
        // Fetch existing category or throw an exception
        PaymentCategoryModel category = paymentCatRepo.findById(PID)
                .orElseThrow(() -> new EntityNotFoundException("Category with ID " + PID + " not found"));

        // Update the category name
//        category.setCategoryName(paymentCategoryModel.getCategoryName());

        // Save and return updated category
        return paymentCatRepo.save(category);
    } catch (EntityNotFoundException e) {
        throw e; // Let the controller handle the exception
    } catch (Exception e) {
        throw new RuntimeException("An unexpected error occurred while updating the category.", e);
    }
}

}
