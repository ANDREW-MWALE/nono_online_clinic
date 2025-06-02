package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.ServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceModel, Long> {
    // Corrected method name to match entity properties exactly
    List<ServiceModel> findByDepartmentContainingIgnoreCaseOrServiceNameContainingIgnoreCase(
            String department,
            String serviceName
    );

    // Alternative safer approach using @Query
    @Query("SELECT s FROM ServiceModel s WHERE " +
            "LOWER(s.department) LIKE LOWER(CONCAT('%', :query, '%')) OR " +
            "LOWER(s.serviceName) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<ServiceModel> searchServices(@Param("query") String query);
}