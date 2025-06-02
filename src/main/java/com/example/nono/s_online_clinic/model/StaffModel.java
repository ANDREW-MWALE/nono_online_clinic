package com.example.nono.s_online_clinic.model;

import jakarta.persistence.*;

@Entity// Shows class is an entity and mapped to a table
//@Table(name = "STAFF")// Optional if no used JPA uses class name as name of a table by default
public class StaffModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="STAFF_NAME")
    private String staffName;
    @Column(name="POSITION")
    private String position;
    @Column(name="LOCATION")
    private String location;
    @Column(name = "DEPT")
    private String department;

    //It allows you to create an object (instance) of the class without needing to pass any arguments when calling the constructor
    public StaffModel() {
    }

    public StaffModel(Long id, String staff_Name, String position, String location, String department) {
        this.id = id;
        staffName = staff_Name;
        this.position = position;
        this.location = location;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
