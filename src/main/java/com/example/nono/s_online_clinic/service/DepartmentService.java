package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.DepartmentModel;
import com.example.nono.s_online_clinic.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    public DepartmentRepo departmentRepo;

    public ResponseEntity<List<DepartmentModel>> getDepartment() {
        List<DepartmentModel> departments = departmentRepo.findAll();
        return ResponseEntity.ok(departments);
    }

    public ResponseEntity<?> createDepartment(DepartmentModel departmentModel) {
       return ResponseEntity.ok(departmentRepo.save(departmentModel));
    }


    public ResponseEntity<?> deleteDepartment(Long id) {
        if (departmentRepo.existsById(id)) {
            departmentRepo.deleteById(id);
            return ResponseEntity.ok("Department deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Department with ID " + id + " not found.");
        }
    }

}
