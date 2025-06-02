package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.PrescriptionModel;
import com.example.nono.s_online_clinic.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<PrescriptionModel> addPrescription(@RequestBody PrescriptionModel prescriptionModel){
    PrescriptionModel presciption = prescriptionService.addPrescription(prescriptionModel);
    return ResponseEntity.ok(presciption);
   }
   @GetMapping
    public ResponseEntity<List<PrescriptionModel>> getAllPrescription(@RequestBody PrescriptionModel prescriptionModel){
        List<PrescriptionModel> prescriptionList = prescriptionService.getAllPrescription();
        return ResponseEntity.ok(prescriptionList);
   }
   @PutMapping("/{pri_id}")
    public ResponseEntity<PrescriptionModel> updatePrescription(@PathVariable Long pri_id, @RequestBody PrescriptionModel prescriptionModel){
       return ResponseEntity.ok((PrescriptionModel) prescriptionService.updatePrescription(pri_id, prescriptionModel));
   }
   @DeleteMapping("/{pri_id}")
    public ResponseEntity<String> deletePrescription(@PathVariable Long pri_id){
         prescriptionService.deletePrescription(pri_id);
         return ResponseEntity.ok(",,,");
   }
}
