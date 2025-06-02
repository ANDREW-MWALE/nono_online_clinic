// EmployeeLeaveBalanceRepository.java
package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.EmployeeLeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeLeaveBalanceRepository extends JpaRepository<EmployeeLeaveBalance, String> {
    Optional<EmployeeLeaveBalance> findByEmployeeId(String employeeId);
}