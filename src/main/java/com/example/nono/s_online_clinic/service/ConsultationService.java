package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.ConsultationModel;
import com.example.nono.s_online_clinic.model.PatientModel;
import com.example.nono.s_online_clinic.repo.ConsultationRepository;
import com.example.nono.s_online_clinic.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {

   @Autowired
    ConsultationRepository consultationRepository;
   PatientRepository patientRepository;
    public ConsultationModel addConsultation(ConsultationModel consultationModel) {
        // Find the patient by ID (assume patientId is part of the consultationModel)
        PatientModel patient = patientRepository.findById(consultationModel.getPatientModel().getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        // Set the patient in the consultation model
        consultationModel.setPatientModel(patient);

        // Save the consultation and return the saved model
        return consultationRepository.save(consultationModel);
    }



    public List<ConsultationModel> getAllConsultations() {
        return consultationRepository.findAll();
    }


    public ConsultationModel editConsultation(Long consId, ConsultationModel consultationModel) {
        // Find the existing consultation
        ConsultationModel consultaion = consultationRepository.findById(consId).orElseThrow(() ->
                new RuntimeException("Consultation not found"));

        // Set the updated values
        consultaion.setPatientModel(consultationModel.getPatientModel()); // Set the patient model
        consultaion.setChiefComplaints(consultationModel.getChiefComplaints());
        consultaion.setHistoryOfIllness(consultationModel.getHistoryOfIllness());
        consultaion.setFamilyHistory(consultationModel.getFamilyHistory());
        consultaion.setSocialHistory(consultationModel.getSocialHistory());
        consultaion.setManagementPlan(consultationModel.getManagementPlan());

        // Save and return the updated consultation
        return consultationRepository.save(consultaion);
    }


    public void deleteConsultation(Long consId) {
        consultationRepository.deleteById(consId);
    }

    public ConsultationModel saveConsultation(ConsultationModel consultation) {
        return consultationRepository.save(consultation);
    }

}
