package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.DepartmentModel;
import com.example.nono.s_online_clinic.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/department")
    public ResponseEntity <List<DepartmentModel>> getDepartment(){
        return departmentService.getDepartment();

    }
    @PostMapping("/post")
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentModel departmentModel){
        return departmentService.createDepartment(departmentModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable Long id){
        return departmentService.deleteDepartment(id);
    }



}
