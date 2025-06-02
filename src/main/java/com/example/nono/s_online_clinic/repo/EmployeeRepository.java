package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Employee findByEmail(String email);

    @Query(value = "SELECT id FROM employee ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String findLatestId();
}
