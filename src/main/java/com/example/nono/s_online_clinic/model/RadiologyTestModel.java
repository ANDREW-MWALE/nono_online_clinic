package com.example.nono.s_online_clinic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RadiologyTestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String testName;
    private String Department;
    private float testCharge;

    public RadiologyTestModel() {
    }

    public RadiologyTestModel(Long id, String testName, String department, float testCharge) {
        this.id = id;
        this.testName = testName;
        Department = department;
        this.testCharge = testCharge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public float getTestCharge() {
        return testCharge;
    }

    public void setTestCharge(float testCharge) {
        this.testCharge = testCharge;
    }
}
