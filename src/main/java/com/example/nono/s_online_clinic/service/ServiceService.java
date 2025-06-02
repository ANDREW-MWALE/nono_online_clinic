package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.ServiceModel;
import com.example.nono.s_online_clinic.repo.ServiceRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceService {
    private final ServiceRepository serviceRepository;

    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<ServiceModel> getAllServices() {
        return serviceRepository.findAll();
    }

    public List<ServiceModel> searchServices(String query) {
        // Use either the derived query method
        return serviceRepository.findByDepartmentContainingIgnoreCaseOrServiceNameContainingIgnoreCase(
                query, query);

        // OR use the @Query version
        // return serviceRepository.searchServices(query);
    }

    public ServiceModel createService(ServiceModel serviceModel) {
        return serviceRepository.save(serviceModel);
    }
}