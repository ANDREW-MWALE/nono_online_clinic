package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.Employee;
import com.example.nono.s_online_clinic.model.EmployeeLeaveBalance;
import com.example.nono.s_online_clinic.repo.EmployeeLeaveBalanceRepository;
import com.example.nono.s_online_clinic.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeLeaveBalanceRepository leaveBalanceRepository;

    public String generateEmployeeId() {
        String lastId = employeeRepository.findLatestId(); // e.g. RPH009
        int number = 1;

        if (lastId != null && lastId.startsWith("RPH")) {
            try {
                number = Integer.parseInt(lastId.substring(3)) + 1;
            } catch (NumberFormatException ignored) {}
        }

        return String.format("RPH%03d", number); // e.g. RPH010
    }

    public Employee register(Employee employee) {
        String newId = generateEmployeeId();
        employee.setId(newId);
        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeLeaveBalance leave = new EmployeeLeaveBalance();
        leave.setEmployeeId(newId);
        leaveBalanceRepository.save(leave);

        return savedEmployee;
    }
}
