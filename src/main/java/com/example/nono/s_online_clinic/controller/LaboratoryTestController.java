package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.LaboratoryTestModel;
import com.example.nono.s_online_clinic.model.OrderModel;
import com.example.nono.s_online_clinic.service.LaboratoryTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/laboratoryTest")
public class LaboratoryTestController {

    @Autowired
    private LaboratoryTestService laboratoryTestService;

    @PostMapping("/add")
    public ResponseEntity<?> addLaboratoryTest(@RequestBody LaboratoryTestModel laboratoryTest) {
        try {
            LaboratoryTestModel savedTest = laboratoryTestService.addLaboratoryTest(laboratoryTest);
            return ResponseEntity.ok(savedTest);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding test: " + e.getMessage());
        }
    }
    @PostMapping("/addorder")
    public ResponseEntity<?> addLaboratoryOrders(@RequestBody OrderModel orderModel) {
        try {
            OrderModel saveLabOrders = laboratoryTestService.addLabOrders(orderModel);
            return ResponseEntity.ok(saveLabOrders);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding lab order: " + e.getMessage());
        }
    }
    @GetMapping("/get")
    public ResponseEntity<List<LaboratoryTestModel>> getLaboratoryTest(){
        List<LaboratoryTestModel> laboratoryTest = laboratoryTestService.getAllLaboratoryTest();
        return ResponseEntity.ok(laboratoryTest);
    }
}