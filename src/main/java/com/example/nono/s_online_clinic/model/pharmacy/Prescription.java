package com.example.nono.s_online_clinic.model.pharmacy;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rxNumber;
    private String patient;
    private String doctor;
    private LocalDate dateIssued;
    private int refillsAllowed;
    private int refillsUsed;
    private String status; // "pending" | "dispensed" | "expired"
    private String notes;

    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<PrescriptionItem> items;
}