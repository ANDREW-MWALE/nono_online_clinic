package com.example.nono.s_online_clinic.model.LaboratoryModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LaboratorySampleTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private Long sampleTypeId;
    private String sampleName;
    //to be added
    //1. category e.g
    private String updatedBy;
    private String modifiedBy;
    private LocalDateTime updateDate;
    private LocalDateTime modifiedDate;
}

