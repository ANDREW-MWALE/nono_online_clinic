package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.DTO.PatientDTO;
import com.example.nono.s_online_clinic.model.PatientModel;
import com.example.nono.s_online_clinic.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Add this conversion method
    private PatientDTO convertToDTO(PatientModel patient) {
        if (patient == null) {
            return null;
        }

        PatientDTO dto = new PatientDTO();
        dto.setPatientId(patient.getPatientId());
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());
        dto.setRegistrationDate(patient.getRegistrationDate());
        // Add any other fields you need to map

        return dto;
    }

    public List<PatientModel> getAllPatients() {
        return patientRepository.findAll();
    }

    public List<PatientDTO> findPatientsRegisteredOn(LocalDate date) {
        return patientRepository.findByRegistrationDate(date)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<PatientDTO> findAllPatients() {
        return patientRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PatientModel addPatients(PatientModel patientModel) {
        return patientRepository.save(patientModel);
    }

    public PatientModel getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public PatientModel updatePatientDetails(Long id, PatientModel patientModel) {
        PatientModel patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setFirstName(patientModel.getFirstName());
        patient.setLastName(patientModel.getLastName());
        patient.setAddress(patientModel.getAddress());
        patient.setDateOfBirth(patientModel.getDateOfBirth());
        patient.setPhoneNumber(patientModel.getPhoneNumber());
        patient.setEmailAddress(patientModel.getEmailAddress());
        patient.setCreatedBy(patientModel.getCreatedBy());
        patient.setUpdatedBy(patientModel.getUpdatedBy());
        patient.setUpdatedDate(patientModel.getUpdatedDate());
        patient.setLastUpdatedDate(patientModel.getLastUpdatedDate());

        return patientRepository.save(patient); // Changed from patientModel to patient
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}