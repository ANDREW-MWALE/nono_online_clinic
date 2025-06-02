package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.RadiologyTestModel;
import com.example.nono.s_online_clinic.repo.RadiologyTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RadiologyTestService {
    @Autowired
    public RadiologyTestRepo radiologyTestRepo;

    public RadiologyTestModel addRadiologyTest(RadiologyTestModel radiologyTest) {
        return radiologyTestRepo.save(radiologyTest);
    }

    public List<RadiologyTestModel> getAllRadiologyTest() {
        return radiologyTestRepo.findAll();
    }


}
