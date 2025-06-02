package com.example.nono.s_online_clinic.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
public class Employee {

    @Id
    private String id; // e.g. RPH001

    private String employeeName; // Combined first and last name
    private String email;
    private String contact;
    private String address;
    private String department;
    private String position;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;
    private String password;
    private String role; // e.g. ADMIN, HR, EMPLOYEE

    public Employee() {
    }

    public Employee(String id, String employeeName, String email, String contact, String address,
                    String department, String position, String type, LocalDate startDate,
                    LocalDate endDate, String password, String role) {
        this.id = id;
        this.employeeName = employeeName;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.department = department;
        this.position = position;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.password = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
