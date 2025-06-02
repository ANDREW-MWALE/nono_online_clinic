package com.example.nono.s_online_clinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "consultation_model")
@Getter
@Setter
public class ConsultationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cons_id")
    private Long consId;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id") // Ensure referencing patient_id
    @JsonBackReference
    private PatientModel patientModel;

    @Column(name = "chief_complaints")
    private String chiefComplaints;

    @Column(name = "history_of_illness")
    private String historyOfIllness;

    @Column(name = "family_history")
    private String familyHistory;

    @Column(name = "social_history")
    private String socialHistory;

    @Column(name = "management_plan")
    private String managementPlan;

    public Long getConsId() {
        return consId;
    }

    public void setConsId(Long consId) {
        this.consId = consId;
    }

    public PatientModel getPatientModel() {
        return patientModel;
    }

    public void setPatientModel(PatientModel patientModel) {
        this.patientModel = patientModel;
    }

    public String getChiefComplaints() {
        return chiefComplaints;
    }

    public void setChiefComplaints(String chiefComplaints) {
        this.chiefComplaints = chiefComplaints;
    }

    public String getHistoryOfIllness() {
        return historyOfIllness;
    }

    public void setHistoryOfIllness(String historyOfIllness) {
        this.historyOfIllness = historyOfIllness;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public String getSocialHistory() {
        return socialHistory;
    }

    public void setSocialHistory(String socialHistory) {
        this.socialHistory = socialHistory;
    }

    public String getManagementPlan() {
        return managementPlan;
    }

    public void setManagementPlan(String managementPlan) {
        this.managementPlan = managementPlan;
    }
}
