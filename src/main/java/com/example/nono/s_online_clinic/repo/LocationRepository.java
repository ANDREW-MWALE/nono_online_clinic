package com.example.nono.s_online_clinic.repo;

import com.example.nono.s_online_clinic.model.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationModel, Long> {

}
