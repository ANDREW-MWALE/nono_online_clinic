package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.LaboratoryTestModel;
import com.example.nono.s_online_clinic.model.RadiologyTestModel;
import com.example.nono.s_online_clinic.service.RadiologyTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/radiologyTest")
public class RadiologyTestController {
    @Autowired
    private RadiologyTestService radiologyTestService;

    @PostMapping("/add")
    public ResponseEntity<?> addLaboratoryTest(@RequestBody RadiologyTestModel radiologyTest) {
            try {
                RadiologyTestModel savedTest = radiologyTestService.addRadiologyTest(radiologyTest);
                return ResponseEntity.ok(savedTest);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error adding test: " + e.getMessage());
            }
        }
        @GetMapping("/get")
        public ResponseEntity<List<RadiologyTestModel>> getRadiologyTest(){
            List<RadiologyTestModel> laboratoryTest = radiologyTestService.getAllRadiologyTest();
            return ResponseEntity.ok(laboratoryTest);
        }
    }
