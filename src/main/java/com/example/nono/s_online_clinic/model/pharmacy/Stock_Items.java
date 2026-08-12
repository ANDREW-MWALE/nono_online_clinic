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
public class Stock_Items {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long itemId;   // renamed from Item_id for cleaner casing/JSON key

    private String name;
    private String category;
    private int quantity;
    private LocalDate expiryDate;
    private Double price;   // added

    private String updatedBy;
    private String modifiedBy;
    private LocalDateTime updateDate;
    private LocalDateTime modifiedDate;
}