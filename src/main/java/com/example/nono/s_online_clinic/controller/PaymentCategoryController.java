package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.PaymentCategoryModel;
import com.example.nono.s_online_clinic.service.PaymentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/paymentCategory/")
public class PaymentCategoryController {
    @Autowired
   private PaymentCategoryService paymentCategoryService;
    @PostMapping("add")
    public PaymentCategoryModel addPaymentCategory(@RequestBody PaymentCategoryModel paymentCategoryModel){
        return paymentCategoryService.addPaymentCategory(paymentCategoryModel);
    }
    @GetMapping("/list")
    public ResponseEntity<List<PaymentCategoryModel>> getPaymentCategoryList() {
        List<PaymentCategoryModel> paymentCategoryList = paymentCategoryService.getAllPayList();
        return ResponseEntity.ok(paymentCategoryList);
    }
    @PutMapping("/{PID}")
    public ResponseEntity<?> editPaymentCategory(@PathVariable("PID") Long PID, @RequestBody PaymentCategoryModel paymentCategoryModel) {
        return ResponseEntity.ok(paymentCategoryService.updateCategory(PID, paymentCategoryModel));
    }

}
