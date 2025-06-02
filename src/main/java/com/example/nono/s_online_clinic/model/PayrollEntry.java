package com.example.nono.s_online_clinic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class PayrollEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String position;
    private String department;
    private LocalDate month;
    private double basic;
    private double allowance;
    private double bonus;
    private double loan;
    private double nhima;
    private double napsa;
    private double grossPay;
    private double zra;
    private double insurance;
    private double net;

    public PayrollEntry() {
    }

    public PayrollEntry(Long id,
                        String name,
                        String position,
                        String department,
                        LocalDate month,
                        double basic,
                        double allowance,
                        double bonus,
                        double loan,
                        double nhima,
                        double napsa,
                        double grossPay,
                        double zra,
                        double insurance,
                        double net) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.department = department;
        this.month = month;
        this.basic = basic;
        this.allowance = allowance;
        this.bonus = bonus;
        this.loan = loan;
        this.nhima = nhima;
        this.napsa = napsa;
        this.grossPay = grossPay;
        this.zra = zra;
        this.insurance = insurance;
        this.net = net;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getMonth() {
        return month;
    }

    public void setMonth(LocalDate month) {
        this.month = month;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getNhima() {
        return nhima;
    }

    public void setNhima(double nhima) {
        this.nhima = nhima;
    }

    public double getNapsa() {
        return napsa;
    }

    public void setNapsa(double napsa) {
        this.napsa = napsa;
    }

    public double getGrossPay() {
        return grossPay;
    }

    public void setGrossPay(double grossPay) {
        this.grossPay = grossPay;
    }

    public double getZra() {
        return zra;
    }

    public void setZra(double zra) {
        this.zra = zra;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }


}