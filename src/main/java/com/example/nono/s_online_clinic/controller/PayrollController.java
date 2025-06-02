package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.PayrollEntry;
import com.example.nono.s_online_clinic.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
@CrossOrigin(origins = "8080") // allow requests from frontend
public class PayrollController {

    @Autowired
    private PayrollService service;

    @GetMapping("/fetch")
    public List<PayrollEntry> getAllEntries() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PayrollEntry getEntry(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/add")
    public PayrollEntry createEntry(@RequestBody PayrollEntry entry) {
        return service.save(entry);
    }

    @PutMapping("/{id}")
    public PayrollEntry updateEntry(@PathVariable Long id, @RequestBody PayrollEntry entry) {
        entry.setId(id);
        return service.save(entry);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable Long id) {
        service.delete(id);
    }
}

