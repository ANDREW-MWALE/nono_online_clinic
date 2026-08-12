package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.PatientModel;
import com.example.nono.s_online_clinic.model.VitalModel;
import com.example.nono.s_online_clinic.repo.PatientRepository;
import com.example.nono.s_online_clinic.repo.VitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VitalService {

    @Autowired
    private VitalRepository repo;

    @Autowired
    private PatientRepository patientRepository;

    public VitalModel addvitals(VitalModel vitalModel) {
        // Re-attach a MANAGED PatientModel instead of trusting the transient
        // one Jackson built from the incoming JSON (fixes TransientPropertyValueException)
        Long patientId = vitalModel.getPatientModel().getPatientId(); // adjust getter if your PK field differs
        PatientModel managedPatient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + patientId));

        vitalModel.setPatientModel(managedPatient);
        return repo.save(vitalModel);
    }

    public List<VitalModel> getPatientVitals(Long patientId) {
        return repo.findByPatientModel_PatientId(patientId);
    }

    public List<VitalModel> getAllVitals() {
        return repo.findAll();
    }

    public void updateVitals(Long id, VitalModel vitalModel) {
        VitalModel existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Vital record not found with id: " + id));

        existing.setBodyTemperature(vitalModel.getBodyTemperature());
        existing.setPulseRate(vitalModel.getPulseRate());
        existing.setBloodPressure(vitalModel.getBloodPressure());
        existing.setOxygenSaturation(vitalModel.getOxygenSaturation());
        existing.setRecordedAt(vitalModel.getRecordedAt());

        repo.save(existing);
    }
}