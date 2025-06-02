package com.example.nono.s_online_clinic.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employee_leave_balances")
public class EmployeeLeaveBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private String employeeId; // Use RPH001, etc.

    private int annualLeaveBalance = 20;
    private int sickLeaveBalance = 10;
    private int maternityLeaveBalance = 90;
    private int paternityLeaveBalance = 14;
    private int emergencyLeaveBalance = 5;

    public EmployeeLeaveBalance() {
    }

    public EmployeeLeaveBalance(Long id,
                                String employeeId, int annualLeaveBalance, int sickLeaveBalance, int maternityLeaveBalance, int paternityLeaveBalance, int emergencyLeaveBalance) {
        this.id = id;
        this.employeeId = employeeId;
        this.annualLeaveBalance = annualLeaveBalance;
        this.sickLeaveBalance = sickLeaveBalance;
        this.maternityLeaveBalance = maternityLeaveBalance;
        this.paternityLeaveBalance = paternityLeaveBalance;
        this.emergencyLeaveBalance = emergencyLeaveBalance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getAnnualLeaveBalance() {
        return annualLeaveBalance;
    }

    public void setAnnualLeaveBalance(int annualLeaveBalance) {
        this.annualLeaveBalance = annualLeaveBalance;
    }

    public int getSickLeaveBalance() {
        return sickLeaveBalance;
    }

    public void setSickLeaveBalance(int sickLeaveBalance) {
        this.sickLeaveBalance = sickLeaveBalance;
    }

    public int getMaternityLeaveBalance() {
        return maternityLeaveBalance;
    }

    public void setMaternityLeaveBalance(int maternityLeaveBalance) {
        this.maternityLeaveBalance = maternityLeaveBalance;
    }

    public int getPaternityLeaveBalance() {
        return paternityLeaveBalance;
    }

    public void setPaternityLeaveBalance(int paternityLeaveBalance) {
        this.paternityLeaveBalance = paternityLeaveBalance;
    }

    public int getEmergencyLeaveBalance() {
        return emergencyLeaveBalance;
    }

    public void setEmergencyLeaveBalance(int emergencyLeaveBalance) {
        this.emergencyLeaveBalance = emergencyLeaveBalance;
    }
}
