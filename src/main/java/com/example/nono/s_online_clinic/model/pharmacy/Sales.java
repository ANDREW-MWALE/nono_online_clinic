package com.example.nono.s_online_clinic.model.pharmacy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long saleId;

    private String medicineName;
    private int availableQty;
    private int saleQty;
    private Double unitPrice;
    private Double Amount;
    private String updatedBy;
    private String modifiedBy;
    private LocalDateTime updateDate;
    private LocalDateTime modifiedDate;
}
