package com.example.nono.s_online_clinic.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient_model")
@Getter
@Setter
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;
    private String firstName;
    private String lastName;
    private String address;
    private String dateOfBirth;
    private String phoneNumber;
    private String emailAddress;
    private String consultation;
    private String assignedDoctor;
    private String counsultationType;
    private String amount;
    private LocalDate registrationDate;
    private String createdBy;
    private String updatedBy;
    private Date updatedDate;
    private Date lastUpdatedDate;

    @OneToMany(mappedBy = "patientModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<VitalModel> vitals;

    @OneToMany(mappedBy = "patientModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ConsultationModel> consultations;

    public PatientModel() {
    }

    public PatientModel(Long patientId, String firstName, String lastName, String address, String dateOfBirth, String phoneNumber, String emailAddress, String consultation, String assignedDoctor, String counsultationType, String amount, LocalDate registrationDate, String createdBy, String updatedBy, Date updatedDate, Date lastUpdatedDate, List<VitalModel> vitals, List<ConsultationModel> consultations) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.consultation = consultation;
        this.assignedDoctor = assignedDoctor;
        this.counsultationType = counsultationType;
        this.amount = amount;
        this.registrationDate = registrationDate;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.vitals = vitals;
        this.consultations = consultations;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getConsultation() {
        return consultation;
    }

    public void setConsultation(String consultation) {
        this.consultation = consultation;
    }

    public String getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(String assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    public String getCounsultationType() {
        return counsultationType;
    }

    public void setCounsultationType(String counsultationType) {
        this.counsultationType = counsultationType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
    //    public Long getPatientId() {
//        return patientId;
//    }
//
//    public void setPatientId(Long patientId) {
//        this.patientId = patientId;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(String dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }
//
//    public String getConsultation() {
//        return consultation;
//    }
//
//    public void setConsultation(String consultation) {
//        this.consultation = consultation;
//    }
//
//    public String getAssignedDoctor() {
//        return assignedDoctor;
//    }
//
//    public void setAssignedDoctor(String assignedDoctor) {
//        this.assignedDoctor = assignedDoctor;
//    }
//
//    public String getCounsultationType() {
//        return counsultationType;
//    }
//
//    public void setCounsultationType(String counsultationType) {
//        this.counsultationType = counsultationType;
//    }
//
//    public String getAmount() {
//        return amount;
//    }
//
//    public void setAmount(String amount) {
//        this.amount = amount;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public String getUpdatedBy() {
//        return updatedBy;
//    }
//
//    public void setUpdatedBy(String updatedBy) {
//        this.updatedBy = updatedBy;
//    }
//
//    public Date getUpdatedDate() {
//        return updatedDate;
//    }
//
//    public void setUpdatedDate(Date updatedDate) {
//        this.updatedDate = updatedDate;
//    }
//
//    public Date getLastUpdatedDate() {
//        return lastUpdatedDate;
//    }
//
//    public void setLastUpdatedDate(Date lastUpdatedDate) {
//        this.lastUpdatedDate = lastUpdatedDate;
//    }

    public List<VitalModel> getVitals() {
        return vitals;
    }

    public void setVitals(List<VitalModel> vitals) {
        this.vitals = vitals;
    }

    public List<ConsultationModel> getConsultations() {
        return consultations;
    }

    public void setConsultations(List<ConsultationModel> consultations) {
        this.consultations = consultations;
    }
}
