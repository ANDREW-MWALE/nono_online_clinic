package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.VitalModel;
import com.example.nono.s_online_clinic.repo.VitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VitalService {
    @Autowired
    private VitalRepository repo;

    public VitalModel addVitals(VitalModel model) {
        return repo.save(model);
    }


    public List<VitalModel> getPatientVitals(Long id) {
        return repo.findAll();  // You may want to change this to filter by patientId if needed
    }

    public void updateVitals(Long id, VitalModel vitalModel) {
//        VitalModel vitals = repo.findById(id).orElseThrow(() ->
//                new RuntimeException("Patient's Vitals not found"));
//        vitals.setBodyTemperiture(vitalModel.getBodyTemperiture());
//        vitals.setPulseRate(vitalModel.getPulseRate());
//        vitals.setBloodPressure(vitalModel.getBloodPressure());
//        vitals.setOxygenSaturation(vitalModel.getOxygenSaturation());
//        repo.save(vitals);
    }


    public List<VitalModel> getAllVitals() {
        return repo.findAll();
    }

    public List<VitalModel> getVitalsByPatientId(Long patientId) {
        return repo.findByPatientModel_PatientId(patientId);  // This now matches the repository method
    }

    public VitalModel addvitals(VitalModel vitalModel) {
        return repo.save(vitalModel);
    }
}
