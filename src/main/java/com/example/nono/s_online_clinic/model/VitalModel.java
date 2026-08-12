package com.example.nono.s_online_clinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "vitals_model")
public class VitalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "v_id")
    private Long vId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "body_temperature")   // fixed typo
    private String bodyTemperature;       // fixed typo

    @Column(name = "pulse_rate")
    private String pulseRate;

    @Column(name = "blood_pressure")
    private String bloodPressure;

    @Column(name = "oxygen_saturation")
    private String oxygenSaturation;

    @Column(name = "recorded_at")        // add this
    private java.time.LocalDateTime recordedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "updated_date")
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @JsonBackReference

    private PatientModel patientModel;
}