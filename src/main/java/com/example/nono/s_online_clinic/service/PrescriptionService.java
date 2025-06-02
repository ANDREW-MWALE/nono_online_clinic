package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.PrescriptionModel;
import com.example.nono.s_online_clinic.repo.PrescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionRepo prescriptionRepo;

    public PrescriptionModel addPrescription(PrescriptionModel prescriptionModel) {
        return prescriptionRepo.save(prescriptionModel);
    }


    public List<PrescriptionModel> getAllPrescription() {
        return prescriptionRepo.findAll();
    }

    public Object updatePrescription(Long pri_id, PrescriptionModel prescriptionModel) {
        System.out.println("we here");
        PrescriptionModel prescription = prescriptionRepo.findById(pri_id)
                .orElseThrow(()-> new RuntimeException("Patient not found"));
        System.out.println("we here");
//        prescription.setPri_id(prescriptionModel.getPri_id());
        prescription.setItemDetail(prescriptionModel.getItemDetail());
        prescription.setRoute(prescriptionModel.getRoute());
        prescription.setDosage(prescriptionModel.getDosage());
        prescription.setDosageUnit(prescriptionModel.getDosageUnit());
        prescription.setDrugNumber(prescriptionModel.getDrugNumber());
        prescription.setFrequency(prescriptionModel.getFrequency());
        prescription.setDuration(prescriptionModel.getDuration());
        prescription.setDurationUnit(prescriptionModel.getDurationUnit());
        prescription.setTotalQuantity(prescriptionModel.getTotalQuantity());
        prescription.setCreateBy(prescriptionModel.getCreateBy());
        prescription.setCreatedDate(prescriptionModel.getCreatedDate());
        prescription.setUpdatedBy(prescriptionModel.getUpdatedBy());
        prescription.setUpdatedDate(prescriptionModel.getUpdatedDate());

        return  prescriptionRepo.save(prescription);
    }


    public void deletePrescription(Long pri_id) {
        prescriptionRepo.deleteById(pri_id);
    }
}

