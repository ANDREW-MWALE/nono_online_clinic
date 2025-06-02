package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.VitalModel;
import com.example.nono.s_online_clinic.repo.VitalRepository;
import com.example.nono.s_online_clinic.service.VitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/vitals/")
public class VitalController {

    @Autowired
    private VitalService vitalService;
    private VitalRepository repo;

    @PostMapping("add")
    public ResponseEntity<VitalModel> addVitals(@RequestBody VitalModel vitalMmodel) {
        VitalModel vital = vitalService.addvitals(vitalMmodel);
        return ResponseEntity.ok(vital);
    }

    @GetMapping("/all")
    public ResponseEntity<List<VitalModel>> getAllListing() {
        List<VitalModel> vitalModel = vitalService.getAllVitals(); // Call correct method
        return ResponseEntity.ok(vitalModel);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<VitalModel>> getPatientVitals(@PathVariable Long id) {
        List<VitalModel> vitals = vitalService.getPatientVitals(id);
        return ResponseEntity.ok(vitals);
    }


    @GetMapping("/vitals/{patientId}")
    public List<VitalModel> getVitalsByPatient(@PathVariable Long patientId) {
        return vitalService.getVitalsByPatientId(patientId); // Fetch vitals for the given patient ID
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<List<VitalModel>> getPatientVitals(@PathVariable Long id) {
//        List<VitalModel> vitals = vitalService.getPatientVitals(id);
//        return ResponseEntity.ok(vitals);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<VitalModel> updateVitals(@PathVariable Long id, @RequestBody VitalModel vitalModel) {
        vitalService.updateVitals(id, vitalModel);
        return ResponseEntity.ok(vitalModel);
    }
//    @GetMapping("/vitals/{patientId}")
//    public ResponseEntity<Optional<VitalModel>> getVitalsByPatientId(@PathVariable Long patientId) {
//        Optional<VitalModel> vitals = vitalService.getVitalsByPatientId(patientId);
//        return ResponseEntity.ok(vitals);
//    }

}
