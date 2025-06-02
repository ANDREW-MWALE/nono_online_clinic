package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.ConsultionType;
import com.example.nono.s_online_clinic.repo.ConsultationTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationTypeService {

    @Autowired
    private ConsultationTypeRepo consultationTypeRepo;

    public ConsultionType addConsultationType(ConsultionType consultionType) {
        return consultationTypeRepo.save(consultionType);
    }

    public ResponseEntity<?> fetchConsultation(ConsultionType consultionType) {
        return (ResponseEntity<?>) consultationTypeRepo.findAll();
    }

    public List<ConsultionType> fetchAllConsultationTypes() {
        return consultationTypeRepo.findAll();
    }
}
