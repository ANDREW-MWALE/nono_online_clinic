package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.ConsultationModel;
import com.example.nono.s_online_clinic.model.PatientModel;
import com.example.nono.s_online_clinic.service.ConsultationService;
import com.example.nono.s_online_clinic.service.PatientService;  // Assuming you have a PatientService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/consultation/")
public class ConsultationController {
    @Autowired
    private final ConsultationService consultationService;

    @Autowired
    private final PatientService patientService;  // Assuming you have a PatientService

    // Constructor injection
    public ConsultationController(ConsultationService consultationService, PatientService patientService) {
        this.consultationService = consultationService;
        this.patientService = patientService;
    }
    @PostMapping
    public ResponseEntity<PatientModel> insertPatientsDetails(@RequestBody PatientModel patientModel) {

        System.out.println(patientModel.getFirstName());

        PatientModel patient = patientService.addPatients(patientModel);

        return ResponseEntity.ok(patient);
    }

    @PostMapping("add")
    public ResponseEntity<ConsultationModel> addConsultation(@RequestBody ConsultationModel consultation) {
        // Validate that the consultation has a patient
        if (consultation.getPatientModel() == null || consultation.getPatientModel().getPatientId() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        // Ensure the patient exists
        PatientModel patient = patientService.getPatientById(consultation.getPatientModel().getPatientId());
        if (patient == null) {
            return ResponseEntity.badRequest().body(null); // or return a specific message
        }

        // Set the patient in the consultation (in case it's not already set)
        consultation.setPatientModel(patient);

        // Save the consultation
        ConsultationModel savedConsultation = consultationService.saveConsultation(consultation);

        return ResponseEntity.ok(savedConsultation); // Return the saved consultation
    }


    @GetMapping("get")
    public ResponseEntity<List<ConsultationModel>> getConsultationList(){
        List<ConsultationModel> consultations = consultationService.getAllConsultations();
        return ResponseEntity.ok(consultations);
    }

    @PutMapping("{cons_id}")
    public ResponseEntity<ConsultationModel> updateConsultations(@PathVariable Long cons_id, @RequestBody ConsultationModel consultationModel){
        return ResponseEntity.ok(consultationService.editConsultation(cons_id, consultationModel));
    }

    @DeleteMapping("{cons_id}")
    public ResponseEntity<?> deleteConsultation(@PathVariable Long cons_id){
        consultationService.deleteConsultation(cons_id);
        return ResponseEntity.ok("Consultation successfully deleted");
    }
}
