package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.ConsultionType;
import com.example.nono.s_online_clinic.service.ConsultationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/consultationtype") // Removed trailing slash
public class ConsultationTypeController {

    @Autowired
    private ConsultationTypeService consultationTypeService;

    @PostMapping("add")
    public ConsultionType addConsultationType(@RequestBody ConsultionType consultionType) {
        return consultationTypeService.addConsultationType(consultionType);
    }

    @GetMapping("fetch") // Removed leading slash
    public ResponseEntity<List<ConsultionType>> fetchAllConsultationTypes() {
        return ResponseEntity.ok(consultationTypeService.fetchAllConsultationTypes());
    }
}