package com.example.nono.s_online_clinic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "payment_category")
@Setter
@Getter
public class PaymentCategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PID;
    private String categoryName;

    public PaymentCategoryModel() {
    }

    public PaymentCategoryModel(Long PID, String categoryName) {
        this.PID = PID;
        this.categoryName = categoryName;
    }
}
