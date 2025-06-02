package com.example.nono.s_online_clinic.model;

public class Payroll {
    private int grossSalary;
    private int napsa;
    private int payee;
    private int netPay;

    public Payroll() {
    }

    public Payroll(int grossSalary, int napsa, int payee, int netPay){
        this.grossSalary = grossSalary;
        this.napsa = napsa;
        this.payee = payee;
        this.netPay =netPay;
}

    public int getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(int grossSalary) {
        this.grossSalary = grossSalary;
    }

    public int getNapsa() {
        return napsa;
    }

    public void setNapsa(int napsa) {
        this.napsa = napsa;
    }

    public int getPayee() {
        return payee;
    }

    public void setPayee(int payee) {
        this.payee = payee;
    }

    public int getNetPay() {
        return netPay;
    }

    public void setNetPay(int netPay) {
        this.netPay = netPay;
    }
}
