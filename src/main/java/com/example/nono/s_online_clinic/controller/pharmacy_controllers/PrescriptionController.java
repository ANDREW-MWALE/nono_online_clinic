package com.example.nono.s_online_clinic.controller.pharmacy_controllers;

import com.example.nono.s_online_clinic.model.pharmacy.Prescription;
import com.example.nono.s_online_clinic.service.pharmacy_services.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping("/add")
    public Prescription addPrescription(@RequestBody Prescription prescription) {
        return prescriptionService.add(prescription);
    }

    @GetMapping
    public ResponseEntity<List<Prescription>> getPrescriptions() {
        List<Prescription> items = prescriptionService.getAll();
        if (items.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription) {
        return ResponseEntity.ok(prescriptionService.update(id, prescription));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Prescription> deletePrescription(@PathVariable Long id) {
        return ResponseEntity.ok(prescriptionService.delete(id));
    }

    @PutMapping("/{id}/dispense")
    public ResponseEntity<Prescription> dispensePrescription(@PathVariable Long id) {
        return ResponseEntity.ok(prescriptionService.dispense(id));
    }

    @PutMapping("/{id}/refill")
    public ResponseEntity<Prescription> refillPrescription(@PathVariable Long id) {
        return ResponseEntity.ok(prescriptionService.refill(id));
    }
}