package com.example.nono.s_online_clinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.datetime.DateFormatter;

import java.time.LocalDateTime;

@Entity

public class PrescriptionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pri_id;
    private String itemDetail;
    private String route;
    private String dosage;
    private String dosageUnit;
    private int drugNumber;
    private String frequency;
    private String duration;
    private String durationUnit;
    private String totalQuantity;
    private String createBy;

    @CreationTimestamp
    private LocalDateTime createdDate;
    private String updatedBy;

    @UpdateTimestamp
    private LocalDateTime updatedDate;

    public PrescriptionModel() {
    }

    public PrescriptionModel(Long pri_id,
                             String itemDetail,
                             String route,
                             String dosage,
                             String dosageUnit,
                             int drugNumber,
                             String frequency,
                             String duration,
                             String durationUnit,
                             String totalQuantity,
                             String createBy,
                             LocalDateTime createdDate,
                             String updatedBy,
                             LocalDateTime updatedDate) {
        this.pri_id = pri_id;
        this.itemDetail = itemDetail;
        this.route = route;
        this.dosage = dosage;
        this.dosageUnit = dosageUnit;
        this.drugNumber = drugNumber;
        this.frequency = frequency;
        this.duration = duration;
        this.durationUnit = durationUnit;
        this.totalQuantity = totalQuantity;
        this.createBy = createBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
    }

    public Long getPri_id() {
        return pri_id;
    }

    public void setPri_id(Long pri_id) {
        this.pri_id = pri_id;
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(String dosageUnit) {
        this.dosageUnit = dosageUnit;
    }

    public int getDrugNumber() {
        return drugNumber;
    }

    public void setDrugNumber(int drugNumber) {
        this.drugNumber = drugNumber;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDurationUnit() {
        return durationUnit;
    }

    public void setDurationUnit(String durationUnit) {
        this.durationUnit = durationUnit;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}
