/*Auth controller is acting as a controller for the employee
* system and it allow the allocation of the password */



package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.DTO.LoginRequest;
import com.example.nono.s_online_clinic.model.Employee;
import com.example.nono.s_online_clinic.model.PatientModel;
import com.example.nono.s_online_clinic.repo.EmployeeRepository;
import com.example.nono.s_online_clinic.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "8080")
public class AuthController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Employee employee = employeeRepository.findByEmail(loginRequest.getEmail());

        if (employee == null || !employee.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("user", employee); // You may customize to return only selected fields

        return ResponseEntity.ok(employee);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Employee employee) {
        if (employeeRepository.findByEmail(employee.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email already registered");
        }

        Employee saved = employeeService.register(employee);
        return ResponseEntity.ok("Registration successful. ID: " + saved.getId());
    }

    @GetMapping("/register")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }
 //update method (editing the employee)
 @PutMapping("/{id}")
 public ResponseEntity<Employee> updateEmployeeDetails(@PathVariable String id, @RequestBody Employee updatedEmployee) {
     return employeeRepository.findById(id)
             .map(existingEmployee -> {
                 // Update the fields
                 existingEmployee.setEmployeeName(updatedEmployee.getEmployeeName());
                 existingEmployee.setEmail(updatedEmployee.getEmail());
                 existingEmployee.setContact(updatedEmployee.getContact());
                 existingEmployee.setAddress(updatedEmployee.getAddress());
                 existingEmployee.setDepartment(updatedEmployee.getDepartment());
                 existingEmployee.setPosition(updatedEmployee.getPosition());
                 existingEmployee.setType(updatedEmployee.getType());
                 existingEmployee.setStartDate(updatedEmployee.getStartDate());
                 existingEmployee.setEndDate(updatedEmployee.getEndDate());
                 existingEmployee.setPassword(updatedEmployee.getPassword());
                 existingEmployee.setRole(updatedEmployee.getRole());

                 // Save updated employee
                 Employee saved = employeeRepository.save(existingEmployee);
                 return ResponseEntity.ok(saved);
             })
             .orElse(ResponseEntity.notFound().build());
 }

    //deleting employee by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable String id) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        employeeRepository.deleteById((id));
        return ResponseEntity.noContent().build();
    }
}
