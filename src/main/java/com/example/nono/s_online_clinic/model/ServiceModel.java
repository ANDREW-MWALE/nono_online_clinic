package com.example.nono.s_online_clinic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "services")
public class ServiceModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "department", nullable = false) // Changed to match repository
    private String department; // Changed from serviceDepartment

    @Column(name = "payment_category", nullable = false)
    private String paymentCategory;

    @Column(nullable = false)
    private double amount;

    // Constructors
    public ServiceModel() {}

    // Getters and setters for all fields
    // Make sure to update the getter/setter names to match the new field name
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPaymentCategory() {
        return paymentCategory;
    }

    public void setPaymentCategory(String paymentCategory) {
        this.paymentCategory = paymentCategory;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}