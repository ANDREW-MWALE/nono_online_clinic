package com.example.nono.s_online_clinic.controller;
import com.example.nono.s_online_clinic.model.PharmacyModel;
import com.example.nono.s_online_clinic.service.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pharmacy/")
public class PharmacyController {
    @Autowired
    public PharmacyService service;

    @PostMapping("add")
    public ResponseEntity<PharmacyModel>  addMedicine(@RequestBody PharmacyModel pharmacyModel){
        return ResponseEntity.ok(service.addMedicine(pharmacyModel));
    }
@GetMapping("get")
    public ResponseEntity<List<PharmacyModel>> getMedication(){
        List<PharmacyModel> getmedication = service.getAllMedication();
        return ResponseEntity.ok(getmedication);
    }
}
