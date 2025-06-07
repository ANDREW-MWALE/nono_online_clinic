package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.EmployeePositionModel;
import com.example.nono.s_online_clinic.service.EmployeePositionService;
import com.example.nono.s_online_clinic.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/positions")
public class EmployeePositionsController {

    @Autowired
    private EmployeePositionService employeePositionService;

    @GetMapping("/get")
    public ResponseEntity <List<EmployeePositionModel>> getEmployeePosition(){
        return employeePositionService.getEmployeePosition();
    }

    @PostMapping("/post")
    public ResponseEntity<?> createEmployeePosition(@RequestBody EmployeePositionModel employeePositionModel){
        return employeePositionService.postEmployeePosition(employeePositionModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeePosition(@PathVariable Long id){
       return employeePositionService.deleteEmployeePosition(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployeePosition(
            @PathVariable Long id,
            @RequestBody EmployeePositionModel updatedPosition) {
        return employeePositionService.updateEmployeePosition(id, updatedPosition);
    }




}
