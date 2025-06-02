package com.example.nono.s_online_clinic.controller;

import com.example.nono.s_online_clinic.model.LocationModel;
import com.example.nono.s_online_clinic.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/location")
public class LocationController {
@Autowired
    private LocationService locationService;

    @GetMapping
    public ResponseEntity<List<LocationModel>> getAllLocations() {
        // No need to cast here, just return the list
        List<LocationModel> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }

    @PostMapping
    private ResponseEntity<LocationModel> insertLocations(@RequestBody LocationModel locationModel){
        return ResponseEntity.ok(locationService.insertLocation(locationModel));
    }
    @PutMapping("/{id}")
    private ResponseEntity<LocationModel> updateLocations(@PathVariable Long id, @RequestBody LocationModel locationModel ){
        return ResponseEntity.ok(locationService.updateLocations(id, locationModel));
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteMapping(@PathVariable Long id){
        locationService.deleteLocation(id);
        return ResponseEntity.ok("Location successfully deleted");
    }


}
