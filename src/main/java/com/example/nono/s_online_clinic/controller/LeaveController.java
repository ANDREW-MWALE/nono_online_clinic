package com.example.nono.s_online_clinic.controller;



import com.example.nono.s_online_clinic.DTO.LeaveApplicationDTO;
import com.example.nono.s_online_clinic.DTO.LeaveRequestDTO;
import com.example.nono.s_online_clinic.DTO.LeaveStatsDTO;
import com.example.nono.s_online_clinic.DTO.LeaveStatusUpdateDTO;
import com.example.nono.s_online_clinic.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@RequiredArgsConstructor
@CrossOrigin(origins = "8080")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping
    public ResponseEntity<List<LeaveApplicationDTO>> getAllLeaves() {
        return ResponseEntity.ok(leaveService.getAllLeaves());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<LeaveApplicationDTO>> getLeavesByEmployeeId(@PathVariable String employeeId) {
        return ResponseEntity.ok(leaveService.getLeavesByEmployeeId(employeeId));
    }

    @GetMapping("/pending")
    public ResponseEntity<List<LeaveApplicationDTO>> getPendingLeaves() {
        return ResponseEntity.ok(leaveService.getPendingLeaves());
    }

    @PostMapping
    public ResponseEntity<LeaveApplicationDTO> applyForLeave(@RequestBody LeaveRequestDTO leaveRequest) {
        return ResponseEntity.ok(leaveService.applyForLeave(leaveRequest));
    }
    @PutMapping("/status/{leaveId}")
    public ResponseEntity<LeaveApplicationDTO> updateLeaveStatus(
            @PathVariable("leaveId") Long leaveId,
            @RequestBody LeaveStatusUpdateDTO statusUpdate) {

        // Ensure the path variable is set in the DTO
        statusUpdate.setLeaveId(leaveId);

        // Add validation
        if (statusUpdate.getStatus() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status is required");
        }

        return ResponseEntity.ok(leaveService.updateLeaveStatus(statusUpdate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveApplicationDTO> getLeaveById(@PathVariable Long id) {
        return ResponseEntity.ok(leaveService.getLeaveById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
        leaveService.deleteLeave(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/stats/{employeeId}")
    public ResponseEntity<LeaveStatsDTO> getLeaveStats(@PathVariable String employeeId) {
        return ResponseEntity.ok(leaveService.getLeaveStats(employeeId));
    }
}