package com.example.nono.s_online_clinic.service;

import com.example.nono.s_online_clinic.model.LaboratoryTestModel;
import com.example.nono.s_online_clinic.model.OrderModel;
import com.example.nono.s_online_clinic.repo.LabOrderRepo;
import com.example.nono.s_online_clinic.repo.LaboratoryTestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryTestService {

    @Autowired
    public LaboratoryTestRepo laboratoryTestRepo;
    public LabOrderRepo labOrderRepo;


    public LaboratoryTestModel addLaboratoryTest(LaboratoryTestModel laboratoryTest) {
       return laboratoryTestRepo.save(laboratoryTest);
    }

    public List<LaboratoryTestModel> getAllLaboratoryTest() {
        return laboratoryTestRepo.findAll();
    }

    public OrderModel addLabOrders(OrderModel orderModel) {
        return labOrderRepo.save(orderModel);
    }
}
