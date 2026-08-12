//package com.example.nono.s_online_clinic.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//@Data
//@Entity
//public class PharmacyModel {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String medicineName;
//    private String supplier_id;
//    private String category_id;
//    private String batchNo;
//    private float quantity;
//    private float orderPrice;
//    private float sellingPrice;
//    private float enteredBy;
//    private String updatedBy;
//
//    private LocalDateTime updatedDate;
//    private LocalDateTime lastUpdatedDate;
//
//    @PrePersist
//    protected void onCreate() {
//        LocalDateTime now = LocalDateTime.now();
//        this.updatedDate = now;
//        this.lastUpdatedDate = now;
//    }
//
//    @PreUpdate
//    protected void onUpdate() {
//        this.lastUpdatedDate = LocalDateTime.now();
//    }
//    public PharmacyModel() {
//    }
//
//    public PharmacyModel(Long id,
//                         String medicineName,
//                         String supplier_id,
//                         String category_id,
//                         String batchNo,
//                         float quantity,
//                         float orderPrice,
//                         float sellingPrice,
//                         float enteredBy,
//                         String updatedBy,
//                         LocalDateTime updatedDate,
//                         LocalDateTime lastUpdatedDate) {
//        this.id = id;
//        this.medicineName = medicineName;
//        this.supplier_id = supplier_id;
//        this.category_id = category_id;
//        this.batchNo = batchNo;
//        this.quantity = quantity;
//        this.orderPrice = orderPrice;
//        this.sellingPrice = sellingPrice;
//        this.enteredBy = enteredBy;
//        this.updatedBy = updatedBy;
//        this.updatedDate = updatedDate;
//        this.lastUpdatedDate = lastUpdatedDate;
//    }
//}
