package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.VitalModel;
import com.example.nono.s_online_clinic.service.VitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vitals")
public class VitalController {

    @Autowired
    private VitalService vitalService;

    @PostMapping("/add")
    public ResponseEntity<VitalModel> addVitals(@RequestBody VitalModel vitalModel) {
        VitalModel vital = vitalService.addvitals(vitalModel);
        return ResponseEntity.ok(vital);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VitalModel>> getAllListing() {
        return ResponseEntity.ok(vitalService.getAllVitals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<VitalModel>> getPatientVitals(@PathVariable Long id) {
        return ResponseEntity.ok(vitalService.getPatientVitals(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VitalModel> updateVitals(@PathVariable Long id, @RequestBody VitalModel vitalModel) {
        vitalService.updateVitals(id, vitalModel);
        return ResponseEntity.ok(vitalModel);
    }
}