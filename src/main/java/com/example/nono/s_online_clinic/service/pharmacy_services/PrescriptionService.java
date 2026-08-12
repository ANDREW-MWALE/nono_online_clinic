package com.example.nono.s_online_clinic.service.pharmacy_services;

import com.example.nono.s_online_clinic.model.pharmacy.Prescription;
import com.example.nono.s_online_clinic.repo.pharmacy_repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    public Prescription add(Prescription prescription) {
        if (prescription.getItems() != null) {
            prescription.getItems().forEach(item -> item.setPrescription(prescription));
        }
        return prescriptionRepository.save(prescription);
    }

    public List<Prescription> getAll() {
        return prescriptionRepository.findAll();
    }

    public Prescription update(Long id, Prescription updated) {
        Prescription existing = prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));

        existing.setPatient(updated.getPatient());
        existing.setDoctor(updated.getDoctor());
        existing.setDateIssued(updated.getDateIssued());
        existing.setRefillsAllowed(updated.getRefillsAllowed());
        existing.setStatus(updated.getStatus());
        existing.setNotes(updated.getNotes());

        existing.getItems().clear();
        if (updated.getItems() != null) {
            updated.getItems().forEach(item -> {
                item.setPrescriptionItemId(null);
                item.setPrescription(existing);
                existing.getItems().add(item);
            });
        }

        return prescriptionRepository.save(existing);
    }

    public Prescription delete(Long id) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));
        prescriptionRepository.delete(prescription);
        return prescription;
    }

    public Prescription dispense(Long id) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));
        prescription.setStatus("dispensed");
        return prescriptionRepository.save(prescription);
    }

    public Prescription refill(Long id) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));
        if (prescription.getRefillsUsed() >= prescription.getRefillsAllowed()) {
            throw new RuntimeException("No refills remaining");
        }
        prescription.setRefillsUsed(prescription.getRefillsUsed() + 1);
        return prescriptionRepository.save(prescription);
    }
}