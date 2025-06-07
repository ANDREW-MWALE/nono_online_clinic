package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.DTO.LeaveApplicationDTO;
import com.example.nono.s_online_clinic.DTO.LeaveRequestDTO;
import com.example.nono.s_online_clinic.DTO.LeaveStatsDTO;
import com.example.nono.s_online_clinic.DTO.LeaveStatusUpdateDTO;
import com.example.nono.s_online_clinic.exceptions.LeaveBalanceException;
import com.example.nono.s_online_clinic.exceptions.LeaveNotFoundException;
import com.example.nono.s_online_clinic.model.EmployeeLeaveBalance;
import com.example.nono.s_online_clinic.model.LeaveApplication;
import com.example.nono.s_online_clinic.model.LeaveStatus;
import com.example.nono.s_online_clinic.model.LeaveType;
import com.example.nono.s_online_clinic.repo.EmployeeLeaveBalanceRepository;
import com.example.nono.s_online_clinic.repo.LeaveApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.nono.s_online_clinic.model.LeaveStatus.*;

@Service
//@RequiredArgsConstructor
@Transactional
public class LeaveService {
    private final LeaveApplicationRepository leaveApplicationRepository;
    private final EmployeeLeaveBalanceRepository leaveBalanceRepository;

    public LeaveService(LeaveApplicationRepository leaveApplicationRepository, EmployeeLeaveBalanceRepository leaveBalanceRepository) {
        this.leaveApplicationRepository = leaveApplicationRepository;
        this.leaveBalanceRepository = leaveBalanceRepository;
    }

    public List<LeaveApplicationDTO> getAllLeaves() {
        return leaveApplicationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<LeaveApplicationDTO> getLeavesByEmployeeId(String employeeId) {
        return leaveApplicationRepository.findByEmployeeId(employeeId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<LeaveApplicationDTO> getPendingLeaves() {
        return leaveApplicationRepository.findByStatus(PENDING).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public LeaveApplicationDTO applyForLeave(LeaveRequestDTO leaveRequest) {
        long days = ChronoUnit.DAYS.between(leaveRequest.getStartDate(), leaveRequest.getEndDate()) + 1;

        // Fetch or create default balance if not found
        EmployeeLeaveBalance balance = leaveBalanceRepository.findByEmployeeId(leaveRequest.getEmployeeId())
                .orElseGet(() -> createDefaultBalance(leaveRequest.getEmployeeId()));

        int remainingBalance = getRemainingBalanceForType(balance, leaveRequest.getLeaveType());

        if (leaveRequest.getLeaveType() != LeaveType.UNPAID && days > remainingBalance) {
            throw new LeaveBalanceException("Insufficient leave balance");
        }

        LeaveApplication leave = new LeaveApplication();
        leave.setEmployeeId(leaveRequest.getEmployeeId());
        leave.setEmployeeName(leaveRequest.getEmployeeName());
        leave.setLeaveType(leaveRequest.getLeaveType());
        leave.setStartDate(leaveRequest.getStartDate());
        leave.setEndDate(leaveRequest.getEndDate());
        leave.setLeaveDays((int) days);
        leave.setReason(leaveRequest.getReason());
        leave.setStatus(PENDING);
        leave.setLeaveBalance(remainingBalance);
        leave.setUpdatedBy("Employee");

        LeaveApplication savedLeave = leaveApplicationRepository.save(leave);
        return convertToDTO(savedLeave);
    }

    private EmployeeLeaveBalance createDefaultBalance(String employeeId) {
        EmployeeLeaveBalance balance = new EmployeeLeaveBalance();
        balance.setEmployeeId(employeeId);
        balance.setAnnualLeaveBalance(20);  // Default annual leave
        balance.setSickLeaveBalance(10);    // Default sick leave
        balance.setMaternityLeaveBalance(90); // Example
        return leaveBalanceRepository.save(balance);
    }

    @Transactional
    public LeaveApplicationDTO updateLeaveStatus(LeaveStatusUpdateDTO statusUpdate) {
        LeaveApplication leave = leaveApplicationRepository.findById(statusUpdate.getLeaveId())
                .orElseThrow(() -> new LeaveNotFoundException("Leave application not found"));

        if (leave.getStatus() == PENDING && statusUpdate.getStatus() == LeaveStatus.APPROVED) {
            EmployeeLeaveBalance balance = leaveBalanceRepository.findByEmployeeId(leave.getEmployeeId())
                    .orElseThrow(() -> new LeaveBalanceException("Leave balance not found for employee"));

            if (leave.getLeaveType() != LeaveType.UNPAID) {
                deductFromBalance(balance, leave.getLeaveType(), leave.getLeaveDays());
                leaveBalanceRepository.save(balance);
                leave.setLeaveBalance(getRemainingBalanceForType(balance, leave.getLeaveType()));
            }
        }

        leave.setStatus(statusUpdate.getStatus());
        leave.setUpdatedBy(statusUpdate.getUpdatedBy());

        LeaveApplication updatedLeave = leaveApplicationRepository.save(leave);
        return convertToDTO(updatedLeave);
    }

    public LeaveApplicationDTO getLeaveById(Long id) {
        LeaveApplication leave = leaveApplicationRepository.findById(id)
                .orElseThrow(() -> new LeaveNotFoundException("Leave application not found"));
        return convertToDTO(leave);
    }

    @Transactional
    public void deleteLeave(Long id) {
        LeaveApplication leave = leaveApplicationRepository.findById(id)
                .orElseThrow(() -> new LeaveNotFoundException("Leave application not found"));

        if (leave.getStatus() == LeaveStatus.APPROVED && leave.getLeaveType() != LeaveType.UNPAID) {
            EmployeeLeaveBalance balance = leaveBalanceRepository.findByEmployeeId(leave.getEmployeeId())
                    .orElseThrow(() -> new LeaveBalanceException("Leave balance not found for employee"));

            addToBalance(balance, leave.getLeaveType(), leave.getLeaveDays());
            leaveBalanceRepository.save(balance);
        }

        leaveApplicationRepository.delete(leave);
    }

    public LeaveStatsDTO getLeaveStats(String employeeId) {
        List<LeaveApplication> leaves = leaveApplicationRepository.findByEmployeeId(employeeId);

        int pending = (int) leaves.stream().filter(l -> l.getStatus() == PENDING).count();
        int approved = (int) leaves.stream().filter(l -> l.getStatus() == LeaveStatus.APPROVED).count();
        int rejected = (int) leaves.stream().filter(l -> l.getStatus() == LeaveStatus.REJECTED).count();

        EmployeeLeaveBalance balance = leaveBalanceRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new LeaveBalanceException("Leave balance not found for employee"));

        int remainingBalance = balance.getAnnualLeaveBalance();

        return new LeaveStatsDTO(pending , approved, rejected ,remainingBalance);
    }

    private int getRemainingBalanceForType(EmployeeLeaveBalance balance, LeaveType type) {
        return switch (type) {
            case ANNUAL -> balance.getAnnualLeaveBalance();
            case SICK -> balance.getSickLeaveBalance();
            case MATERNITY -> balance.getMaternityLeaveBalance();
            case PATERNITY -> balance.getPaternityLeaveBalance();
            case EMERGENCY -> balance.getEmergencyLeaveBalance();
            case UNPAID -> Integer.MAX_VALUE;
        };
    }

    private void deductFromBalance(EmployeeLeaveBalance balance, LeaveType type, int days) {
        switch (type) {
            case ANNUAL -> balance.setAnnualLeaveBalance(balance.getAnnualLeaveBalance() - days);
            case SICK -> balance.setSickLeaveBalance(balance.getSickLeaveBalance() - days);
            case MATERNITY -> balance.setMaternityLeaveBalance(balance.getMaternityLeaveBalance() - days);
            case PATERNITY -> balance.setPaternityLeaveBalance(balance.getPaternityLeaveBalance() - days);
            case EMERGENCY -> balance.setEmergencyLeaveBalance(balance.getEmergencyLeaveBalance() - days);
            case UNPAID -> {}
        }
    }

    private void addToBalance(EmployeeLeaveBalance balance, LeaveType type, int days) {
        switch (type) {
            case ANNUAL -> balance.setAnnualLeaveBalance(balance.getAnnualLeaveBalance() + days);
            case SICK -> balance.setSickLeaveBalance(balance.getSickLeaveBalance() + days);
            case MATERNITY -> balance.setMaternityLeaveBalance(balance.getMaternityLeaveBalance() + days);
            case PATERNITY -> balance.setPaternityLeaveBalance(balance.getPaternityLeaveBalance() + days);
            case EMERGENCY -> balance.setEmergencyLeaveBalance(balance.getEmergencyLeaveBalance() + days);
            case UNPAID -> {}
        }
    }

    private LeaveApplicationDTO convertToDTO(LeaveApplication leave) {
        LeaveApplicationDTO dto = new LeaveApplicationDTO();
        dto.setId(leave.getId());
        dto.setEmployeeId(leave.getEmployeeId());
        dto.setEmployeeName(leave.getEmployeeName());
        dto.setLeaveType(leave.getLeaveType());
        dto.setStartDate(leave.getStartDate());
        dto.setEndDate(leave.getEndDate());
        dto.setLeaveDays(leave.getLeaveDays());
        dto.setReason(leave.getReason());
        dto.setStatus(leave.getStatus());
        dto.setLeaveBalance(leave.getLeaveBalance());
        dto.setUpdatedBy(leave.getUpdatedBy());
        return dto;
    }


}
