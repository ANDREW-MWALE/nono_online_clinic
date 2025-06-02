package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.LocationModel;
import com.example.nono.s_online_clinic.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public List<LocationModel> getAllLocations() {
        return locationRepository.findAll();
    }
    public LocationModel insertLocation(LocationModel locationModel) {
        return locationRepository.save(locationModel);
    }

    public LocationModel updateLocations(Long id, LocationModel locationModel) {
        LocationModel location = locationRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(" staff not present"));
       location.setLocationName(locationModel.getLocationName());
       return locationRepository.save(locationModel);


    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
