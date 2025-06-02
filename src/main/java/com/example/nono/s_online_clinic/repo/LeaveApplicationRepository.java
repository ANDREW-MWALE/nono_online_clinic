// LeaveApplicationRepository.java (which you didn't share but is needed)
package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.LeaveApplication;
import com.example.nono.s_online_clinic.model.LeaveStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LeaveApplicationRepository extends JpaRepository<LeaveApplication, Long> {
    List<LeaveApplication> findByEmployeeId(String employeeId);
    List<LeaveApplication> findByStatus(LeaveStatus status);
}