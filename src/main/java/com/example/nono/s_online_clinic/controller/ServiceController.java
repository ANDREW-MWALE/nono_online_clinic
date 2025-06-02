package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.ServiceModel;
import com.example.nono.s_online_clinic.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/services")
public class ServiceController {
    @Autowired
    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }


    @GetMapping("/get")
    public ResponseEntity<List<ServiceModel>> getAllServices() {
        return ResponseEntity.ok(serviceService.getAllServices());
    }

    @PostMapping
    public ResponseEntity<ServiceModel> createService(@RequestBody ServiceModel serviceModel) {
        ServiceModel createdService = serviceService.createService(serviceModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdService);
    }
}
