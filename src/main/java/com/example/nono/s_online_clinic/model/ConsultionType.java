package com.example.nono.s_online_clinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ConsultionType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String consultationType;
    private String paymentCategory;
    private float ConsultationAmount;

    public ConsultionType() {
    }

    public ConsultionType(Long id, String consultationType,  float consultationAmount, String paymentCategory) {
        this.id = id;
        this.consultationType = consultationType;
        this.paymentCategory = paymentCategory;
        ConsultationAmount = consultationAmount;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConsultationType() {
        return consultationType;
    }

    public void setConsultationType(String consultationType) {
        this.consultationType = consultationType;
    }

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public float getConsultationAmount() {
        return ConsultationAmount;
    }

    public void setConsultationAmount(float consultationAmount) {
        ConsultationAmount = consultationAmount;
    }
}
