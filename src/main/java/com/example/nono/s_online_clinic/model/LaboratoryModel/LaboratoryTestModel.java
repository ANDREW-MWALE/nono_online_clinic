package com.example.nono.s_online_clinic.model.LaboratoryModel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Laboratory Test")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LaboratoryTestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String testName;
    private String Department;
    //sample type to be added |
    private float testCharge;
    private String updatedBy;
    private String modifiedBy;
    private LocalDateTime updateDate;
    private LocalDateTime modifiedDate;
}

