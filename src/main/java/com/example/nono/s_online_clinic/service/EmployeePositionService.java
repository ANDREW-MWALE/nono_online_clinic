package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.EmployeePositionModel;
import com.example.nono.s_online_clinic.repo.EmployeePositionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePositionService {

    @Autowired
    private EmployeePositionRepo employeePositionRepo;

    public ResponseEntity<List<EmployeePositionModel>> getEmployeePosition() {
        List<EmployeePositionModel> postion = employeePositionRepo.findAll();
        return ResponseEntity.ok(postion);
    }

    public ResponseEntity<?> postEmployeePosition(EmployeePositionModel employeePositionModel) {
        return ResponseEntity.ok(employeePositionRepo.save(employeePositionModel));
    }

    public ResponseEntity<?> deleteEmployeePosition(Long id) {
        if(employeePositionRepo.existsById(id)){
            employeePositionRepo.deleteById(id);
            return ResponseEntity.ok().build();
        } else{
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body("The Employee is not present" +id);
        }
    }


    public ResponseEntity<?> updateEmployeePosition(Long id, EmployeePositionModel updatedPosition) {
        // Find the existing position
        EmployeePositionModel existingPosition = employeePositionRepo.findById(id).orElse(null);

        // If position doesn't exist, return 404
        if (existingPosition == null) {
            return ResponseEntity.notFound().build();
        }

        // Update only the position field (since that's all your model has)
        existingPosition.setPosition(updatedPosition.getPosition());

        // Save the updated position
        EmployeePositionModel savedPosition = employeePositionRepo.save(existingPosition);

        // Return the updated position with 200 OK
        return ResponseEntity.ok(savedPosition);
    }


}
