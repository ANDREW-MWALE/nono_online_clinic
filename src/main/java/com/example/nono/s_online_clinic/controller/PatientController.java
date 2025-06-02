package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.DTO.PatientDTO;
import com.example.nono.s_online_clinic.model.PatientModel;
import com.example.nono.s_online_clinic.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    //  Return all patient details (full object)
    @GetMapping()
    public ResponseEntity<List<PatientModel>> getAllPatients() {
        List<PatientModel> listOfPatients = patientService.getAllPatients();
        return ResponseEntity.ok(listOfPatients);
    }

    // Return only first name and last name (DTO)
    @GetMapping("/names")
    public ResponseEntity<List<PatientDTO>> getPatientNames() {
        List<PatientDTO> patientDTOs = patientService.getAllPatients().stream()
                .map(patient -> new PatientDTO(
                        patient.getPatientId(),
                        patient.getFirstName(),
                        patient.getLastName()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(patientDTOs);
    }


    @GetMapping("/today")
    public ResponseEntity<List<PatientDTO>> getTodayPatients(
            @RequestParam String date) {

        LocalDate today = LocalDate.parse(date);
        List<PatientDTO> todayPatients = patientService.findPatientsRegisteredOn(today);
        return ResponseEntity.ok(todayPatients);
    }

    //  Insert new patient
    @PostMapping
    public ResponseEntity<PatientModel> insertPatientsDetails(@RequestBody PatientModel patientModel) {
        PatientModel patient = patientService.addPatients(patientModel);
        return ResponseEntity.ok(patient);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientModel> updatePatientDetails(@PathVariable Long id, @RequestBody PatientModel patientModel) {
        return ResponseEntity.ok(patientService.updatePatientDetails(id, patientModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }
}
