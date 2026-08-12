package com.example.nono.s_online_clinic.model.pharmacy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long supplierId;

    private String supplierName;
    private String contactPerson;
    private String phone;
    private String email;
    private String category;
    private Integer leadTimeDays;
    private String status;
    private Double rating;

    private String updatedBy;
    private String modifiedBy;
    private LocalDateTime updateDate;
    private LocalDateTime modifiedDate;
}