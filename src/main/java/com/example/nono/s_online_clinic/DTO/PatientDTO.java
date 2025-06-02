package com.example.nono.s_online_clinic.DTO;

import java.time.LocalDate;

public class PatientDTO {
    private Long patientId;
    private String firstName;
    private String lastName;
    private LocalDate registrationDate;

    // Default constructor
    public PatientDTO() {}

    // Full constructor
    public PatientDTO(Long patientId, String firstName, String lastName, LocalDate registrationDate) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
    }

    // Constructor for names only
    public PatientDTO(Long patientId, String firstName, String lastName) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
