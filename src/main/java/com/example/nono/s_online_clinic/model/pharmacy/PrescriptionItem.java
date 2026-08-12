package com.example.nono.s_online_clinic.model.pharmacy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionItemId;

    private String dosage;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "itemId")
    private Stock_Items stockItem;

    @ManyToOne
    @JoinColumn(name = "prescription_id")
    @JsonBackReference
    private Prescription prescription;
}